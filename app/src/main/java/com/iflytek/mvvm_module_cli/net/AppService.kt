package com.iflytek.mvvm_module_cli.net

import com.iflytek.commonlib.net.BaseHttpBean
import com.iflytek.mvvm_module_cli.bean.AccountBean
import io.reactivex.Single
import retrofit2.http.GET

interface AppService {

    @GET("/wxarticle/chapters/json")
    fun detail(): Single<BaseHttpBean<List<AccountBean>>>

}