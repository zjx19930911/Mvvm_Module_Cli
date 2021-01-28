package com.example.mvvm.main_module.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.commonlib.net.MyObserver
import com.example.mvvm.main_module.model.MainModel

/**
 * Created by Jianxin on 2021/1/13.
 */

class MainViewModel(application: Application, var model: MainModel?) :
    AndroidViewModel(application) {
    val loginSuccess = MutableLiveData<MainModel>()
    val loginFailed = MutableLiveData<String>()

    fun login(acc: String, pwd: String) {
        model?.login(acc, pwd)?.subscribe(object : MyObserver<MainModel>() {
            override fun onSuccess(data: MainModel?) {
                loginSuccess.value = data;
            }

            override fun onFailed(message: String, code: Int) {
                loginFailed.value = message
            }

        })

    }
}