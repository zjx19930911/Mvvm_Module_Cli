package com.iflytek.commonlib.extens

import android.net.ParseException
import com.google.gson.JsonParseException
import com.iflytek.commonlib.base.BaseViewModel
import com.iflytek.commonlib.net.BaseHttpBean
import com.iflytek.commonlib.net.NetManager.SERVER_SUCCESS_CODE
import com.iflytek.commonlib.net.RxThrowable
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.json.JSONException
import retrofit2.HttpException

/**
 * Created by Jianxin on 2021/2/3.
 */

/**
 * 基本线程扩展函数
 */
fun <T> Single<T>.io2Main(): Single<T>? =
    this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())


/**
 * 扩展函数统一处理请求错误码
 * 返回实体类的rx被观察者
 */
fun <T> Single<BaseHttpBean<T>>.httpDataFilter(): Single<T>? =
    this.io2Main()?.flatMap {
        //解析data层，剔除 code /msg
        if (it.errorCode != SERVER_SUCCESS_CODE) {
            Single.error(RxThrowable(it.errorMsg, it.errorCode))
        } else {
            Single.just(it.data)
        }
    }


/**
 * 扩展函数统一处理异常信息
 */
fun <T> Single<T>.subscribeFilter(
    vm: BaseViewModel,
    successCallback: ((t: T?) -> Unit)? = null,
    errorCallback: ((message: String?, code: Int?) -> Unit)? = null
) =
    this.subscribe(object : SingleObserver<T> {
        override fun onSuccess(t: T) {
            successCallback?.invoke(t)
        }

        override fun onSubscribe(d: Disposable) {
            vm.addDisposable(d)
        }

        override fun onError(e: Throwable) {
            println(e.message)
            if (e is RxThrowable) {
                errorCallback?.invoke(e.message ?: "未知错误", e.code)
            } else {
                if (e is HttpException) {
                    errorCallback?.invoke("网络错误", 500)
                } else if (e is JsonParseException
                    || e is JSONException
                    || e is ParseException
                ) {
                    errorCallback?.invoke("解析错误", 501)
                } else {
                    errorCallback?.invoke("未知错误", 502)
                }
            }
        }
    })


/**
 * 扩展函数纯粹获取http请求结果
 * 统一处理请求错误
 * 偷懒用
 * @param httpSuccess 函数回调正确实体类
 * @param httpError 函数回调异常信息与错误码
 */
fun <T> Single<BaseHttpBean<T>>.httpSubscribe(
    vm: BaseViewModel,
    httpSuccess: ((t: T?) -> Unit)? = null,
    httpError: ((message: String?, code: Int?) -> Unit)? = null
) =
    this.io2Main()?.subscribe(object : SingleObserver<BaseHttpBean<T>> {
        override fun onSuccess(t: BaseHttpBean<T>) {
            if (t.errorCode == SERVER_SUCCESS_CODE) {
                httpSuccess?.invoke(t.data)
            } else {
                httpError?.invoke(t.errorMsg, t.errorCode)
            }
        }

        override fun onSubscribe(d: Disposable) {
            vm.addDisposable(d)
        }

        override fun onError(e: Throwable) {
            println(e.message)
            if (e is HttpException) {
                httpError?.invoke("网络错误", 500)
            } else if (e is JsonParseException
                || e is JSONException
                || e is ParseException
            ) {
                httpError?.invoke("解析错误", 501)
            } else {
                httpError?.invoke("未知错误", 502)
            }
        }

    })

/**
 * 利用compose统一处理请求错误码
 */
fun <T> dataFilterTransfer(): SingleTransformer<BaseHttpBean<T>, T> {
    return SingleTransformer { upstream ->
        upstream.subscribeOn(Schedulers.io())
            //解析data层，剔除 code /msg
            .flatMap { it ->
                if (it.errorCode != SERVER_SUCCESS_CODE) {
                    Single.error(RxThrowable(it.errorMsg, it.errorCode))
                } else {
                    Single.just(it.data)
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
    }
}