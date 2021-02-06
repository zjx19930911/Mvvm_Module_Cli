package com.iflytek.mvvm_cli.model

import android.util.Log
import com.iflytek.commonlib.database.User
import com.iflytek.commonlib.database.dao.UserDao
import com.iflytek.commonlib.extens.httpDataFilter
import com.iflytek.commonlib.extens.io2Main
import com.iflytek.commonlib.net.NetManager
import com.iflytek.commonlib.net.RxThrowable
import com.iflytek.mvvm_cli.net.UserService
import io.reactivex.Single


/**
 * Created by Jianxin on 2021/1/6.
 */
open class AppMainModel(var netManger: NetManager, var userDao: UserDao) {

    fun getUserDetail(): Single<User>? {
        return userDao.getAllUser().map {
            if (it.isNotEmpty()) {
                println("取到数据了")
                it[0]
            } else {
                println("数据为空")
                throw RxThrowable("查询失败")
            }
        }.io2Main()?.onErrorResumeNext {
            println("数据库报错，开始请求网络")
            netManger.getService(UserService::class.java)?.detail()
                ?.httpDataFilter()
                ?.map {
                    return@map User(it.name)
                }
        }
    }

    fun insertUser(user: User) {
        userDao.insertUser(user).io2Main()?.subscribe()
    }
}

