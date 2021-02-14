package com.iflytek.mvvm_module_cli.login_module.net

import com.iflytek.commonlib.net.BaseHttpBean
import com.iflytek.mvvm_module_cli.login_module.bean.LoginBean
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 页面描述：PaoService
 *
 * Created by ditclear on 2017/11/19.
 */
interface LoginService{
    //测试接口
    @GET("/wenda/list/1/json")
    fun login(@Query("phone") phone: String,@Query("password") password: String): Single<BaseHttpBean<LoginBean>>
}