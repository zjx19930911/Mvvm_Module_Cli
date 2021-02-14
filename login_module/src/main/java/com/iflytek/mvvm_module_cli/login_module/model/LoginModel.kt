package com.iflytek.mvvm_module_cli.login_module.model

import com.iflytek.commonlib.extens.httpDataFilter
import com.iflytek.commonlib.net.NetManager
import com.iflytek.mvvm_module_cli.login_module.bean.LoginBean
import com.iflytek.mvvm_module_cli.login_module.net.LoginService
import io.reactivex.*


/**
 * Created by Jianxin on 2021/1/13.
 */

open class LoginModel(private val netManager: NetManager) {


    open fun login(phone: String, password: String): Single<LoginBean>? {
        return netManager.getService(LoginService::class.java)?.login(phone, password)
            ?.httpDataFilter()
    }
}