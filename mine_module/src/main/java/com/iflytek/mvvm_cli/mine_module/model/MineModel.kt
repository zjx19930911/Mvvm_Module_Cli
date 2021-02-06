package com.iflytek.mvvm_cli.mine_module.model

import com.iflytek.commonlib.net.BaseHttpBean
import com.iflytek.commonlib.net.NetManager
import com.iflytek.mvvm_cli.mine_module.net.MineService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Jianxin on 2021/1/13.
 */

class MineModel {
    var token: String? = null

    fun login(phone: String, passwprd: String): Observable<BaseHttpBean<MineModel>>? {
        return NetManager.getService(MineService::class.java)?.login(phone, passwprd)
            ?.subscribeOn(Schedulers.newThread())//请求在新的线程中执行
            ?.observeOn(AndroidSchedulers.mainThread())
    }
}