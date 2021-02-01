package com.iflytek.mvvm_cli.login_module.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.iflytek.commonlib.net.MyObserver
import com.iflytek.mvvm_cli.login_module.model.LoginModel

/**
 * Created by Jianxin on 2021/1/13.
 */

class LoginViewModel(application: Application, var model: LoginModel?) :
    AndroidViewModel(application) {
    val loginSuccess = MutableLiveData<LoginModel>()
    val loginFailed = MutableLiveData<String>()

    fun login(acc: String, pwd: String) {
        model?.login(acc, pwd)?.subscribe(object : MyObserver<LoginModel>() {
            override fun onSuccess(data: LoginModel?) {
                loginSuccess.value = data;
            }

            override fun onFailed(message: String, code: Int) {
                loginFailed.value = message
            }

        })

    }
}