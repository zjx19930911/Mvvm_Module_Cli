package com.iflytek.commonlib.base

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.facebook.stetho.Stetho
import com.iflytek.commonlib.BuildConfig
import com.qmuiteam.qmui.arch.QMUISwipeBackActivityManager

/**
 * Created by Jianxin on 2021/1/26.
 */

open class BaseApplication : Application() {
    //组件application路径
    private val moduleList = arrayOf(
        "com.example.mvvm.mvvm.login_module.LoginApplication",
        "com.example.mvvm.main_module.MainApplication",
        "com.example.mvvm.main_module.MineApplication"
    )

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
        QMUISwipeBackActivityManager.init(this)
        Stetho.initializeWithDefaults(this);
        modulesApplicationInit()
    }

    //通过反射方法找到对应module的application,
    //主工程不再关心module的application初始化
    private fun modulesApplicationInit() {
        for (moduleImpl in moduleList) {
            try {
                val clazz = Class.forName(moduleImpl)
                val `object` = clazz.newInstance()
                if (`object` is ApplicationImpl) {
                    (`object` as ApplicationImpl).onCreateApplication(this)
                }
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: InstantiationException) {
                e.printStackTrace()
            }
        }
    }
}