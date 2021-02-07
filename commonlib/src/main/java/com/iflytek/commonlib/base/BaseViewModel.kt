package com.iflytek.commonlib.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.disposables.Disposable
import java.lang.Exception

/**
 * 防止rxjava的内存泄露
 * Created by Jianxin on 2021/2/7.
 */
open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    var disposableList: MutableList<Disposable> = ArrayList()

    fun addDisposable(disposable: Disposable) {
        disposableList.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        //清除rx请求
        for (disposable in disposableList) {
            try {
                disposable.dispose()
            } catch (e: Exception) {

            }

        }
    }
}