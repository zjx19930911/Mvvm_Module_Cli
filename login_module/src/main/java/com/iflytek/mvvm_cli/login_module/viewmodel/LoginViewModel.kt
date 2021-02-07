package com.iflytek.mvvm_cli.login_module.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.iflytek.commonlib.base.BaseViewModel
import com.iflytek.commonlib.extens.postResult
import com.iflytek.commonlib.extens.subscribeFilter
import com.iflytek.commonlib.liveData.MyMutableLiveData
import com.iflytek.mvvm_cli.login_module.bean.LoginBean
import com.iflytek.mvvm_cli.login_module.model.LoginModel

/**
 * Created by Jianxin on 2021/1/13.
 */

open class LoginViewModel(application: Application, var model: LoginModel?) :
    BaseViewModel(application) {
    val loginResult = MyMutableLiveData<LoginBean>()

    fun login(acc: String, pwd: String) {
        model?.login(acc, pwd)?.subscribeFilter(this,{
            println("成功啦")
            loginResult.postResult(true, it)
        }, { message, code ->
            println("错误信息：$message")
            loginResult.postResult(isSuccess = false, errorMessage = message, code = code)
        })
    }
}