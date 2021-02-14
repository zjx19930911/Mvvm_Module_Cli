package com.iflytek.mvvm_module_cli.main_module

import android.util.Log
import com.iflytek.commonlib.base.ApplicationImpl
import com.iflytek.commonlib.base.BaseApplication
import com.iflytek.mvvm_module_cli.main_module.di.mainAppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Jianxin on 2021/1/26.
 */

class MainApplication : BaseApplication(), ApplicationImpl {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            //开始启动koin
            androidContext(applicationContext)//这边传Application对象,这样你注入的类中,需要app对象的时候,可以直接使用
            modules(mainAppModule)//这里面传各种被注入的模块对象,支持多模块注入
        }
        onCreateApplication(this)
    }

    override fun onCreateApplication(application: BaseApplication?) {
        Log.e("MainApplication","MainApplication init")
    }
}