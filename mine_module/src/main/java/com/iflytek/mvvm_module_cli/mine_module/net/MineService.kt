package com.iflytek.mvvm_module_cli.mine_module.net

import com.iflytek.commonlib.net.BaseHttpBean
import com.iflytek.mvvm_module_cli.mine_module.model.MineModel
import io.reactivex.Observable
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * 页面描述：PaoService
 *
 * Created by ditclear on 2017/11/19.
 */
interface MineService{
    //登录
    @POST("/yxx-app/sso/login")
    fun login(@Query("phone") phone: String,@Query("password") password: String): Observable<BaseHttpBean<MineModel>>
}