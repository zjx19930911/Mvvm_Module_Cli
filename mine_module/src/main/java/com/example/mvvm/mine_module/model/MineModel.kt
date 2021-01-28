package com.example.mvvm.mine_module.model

import com.example.commonlib.net.BaseBean
import com.example.commonlib.net.NetManager
import com.example.mvvm.mine_module.net.MineService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Jianxin on 2021/1/13.
 */

class MineModel {
    var token: String? = null

    fun login(phone: String, passwprd: String): Observable<BaseBean<MineModel>>? {
        return NetManager.getService(MineService::class.java)?.login(phone, passwprd)
            ?.subscribeOn(Schedulers.newThread())//请求在新的线程中执行
            ?.observeOn(AndroidSchedulers.mainThread())
    }
}