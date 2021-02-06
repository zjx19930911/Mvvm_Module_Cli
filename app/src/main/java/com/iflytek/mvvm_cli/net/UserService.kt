package com.iflytek.mvvm_cli.net

import com.iflytek.commonlib.net.BaseHttpBean
import com.iflytek.mvvm_cli.login_module.bean.LoginBean
import com.iflytek.mvvm_cli.login_module.model.LoginModel
import io.reactivex.Single
import retrofit2.http.POST

interface UserService {

    @POST("/yxx-app/sso/login")
    fun detail(): Single<BaseHttpBean<LoginBean>>

}