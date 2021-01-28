package com.example.mvvm.main_module.model

import com.example.commonlib.net.BaseBean
import com.example.commonlib.net.NetManager
import com.example.mvvm.main_module.net.MainService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Jianxin on 2021/1/13.
 */

class MainModel {
    var token: String? = null

    fun login(phone: String, passwprd: String): Observable<BaseBean<MainModel>>? {
        return NetManager.getService(MainService::class.java)?.login(phone, passwprd)
            ?.subscribeOn(Schedulers.newThread())//请求在新的线程中执行
            ?.observeOn(AndroidSchedulers.mainThread())
    }
}