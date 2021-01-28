package com.example.commonlib.net

import android.util.Log
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by Jianxin on 2021/1/8.
 */
abstract class MyObserver<T> : Observer<BaseBean<T>> {
    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {

    }

    override fun onNext(t: BaseBean<T>) {
        if (t.code == 200) {
            onSuccess(t.data)
        } else {
            onFailed(t.message ?: "未知错误", t.code)
        }
    }

    override fun onError(e: Throwable) {
        Log.e("MyObserver","onError："+e.printStackTrace())
        onFailed("网络错误", 250)
    }

    abstract fun onSuccess(data: T?)
    abstract fun onFailed(message: String, code: Int)

}