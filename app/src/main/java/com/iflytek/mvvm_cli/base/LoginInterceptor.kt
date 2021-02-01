package com.iflytek.mvvm_cli.base

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.alibaba.android.arouter.launcher.ARouter
import com.iflytek.commonlib.Constant
import com.iflytek.mvvm_cli.login_module.LoginApplication


/**
 * Created by Jianxin on 2021/1/28.
 */

@Interceptor(priority = 8, name = "用户验证")
class LoginInterceptor : IInterceptor {
    private var context: Context? = null
    override fun process(postcard: Postcard, callback: InterceptorCallback) {
        Log.e("LoginInterceptor", "LoginInterceptor " + postcard.path)
        //判断是否需要验证登录
        if (postcard.extra == 20001) {
            //读取配置文件中的登录状态
            val isLogin: Boolean = LoginApplication.isLogin
            //判断是否登录
            if (isLogin) {
                callback.onContinue(postcard)
            } else {
                Log.e("LoginInterceptor", "未登录，拦截")
                ARouter.getInstance().build(Constant.PATH_ACTIVITY_LOGIN_LOGIN)
                    .withString("path", postcard.path).navigation()
            }
        } else {
            callback.onContinue(postcard)
        }
    }

    override fun init(context: Context?) {
        this.context = context
        Log.e("LoginInterceptor", "LoginInterceptor init")
    }
}