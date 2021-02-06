package com.iflytek.mvvm_cli.login_module.net

import com.iflytek.commonlib.net.BaseHttpBean
import com.iflytek.mvvm_cli.login_module.bean.LoginBean
import com.iflytek.mvvm_cli.login_module.model.LoginModel
import io.reactivex.Single
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * 页面描述：PaoService
 *
 * Created by ditclear on 2017/11/19.
 */
interface LoginService{
    //登录
    @POST("/yxx-app/sso/login")
    fun login(@Query("phone") phone: String,@Query("password") password: String): Single<BaseHttpBean<LoginBean>>
}