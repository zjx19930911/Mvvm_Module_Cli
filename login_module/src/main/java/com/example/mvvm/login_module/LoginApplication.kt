package com.example.mvvm.login_module

import android.util.Log
import com.example.commonlib.base.ApplicationImpl
import com.example.commonlib.base.BaseApplication
import com.example.mvvm.login_module.di.loginAppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Jianxin on 2021/1/26.
 */

class LoginApplication :BaseApplication(),ApplicationImpl{
    companion object {
        var isLogin = false
    }
    override fun onCreate() {
        super.onCreate()
        startKoin {
            //开始启动koin
            androidContext(applicationContext)//这边传Application对象,这样你注入的类中,需要app对象的时候,可以直接使用
            modules(loginAppModule)//这里面传各种被注入的模块对象,支持多模块注入
        }
        onCreateApplication(this)
    }

    override fun onCreateApplication(application: BaseApplication?) {
        Log.e("LoginApplication","LoginApplication init")
    }

}