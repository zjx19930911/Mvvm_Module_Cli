package com.iflytek.mvvm_cli.login_module.viewmodel

import android.app.Application
import com.iflytek.commonlib.net.NetManager
import com.iflytek.mvvm_cli.login_module.bean.LoginBean
import com.iflytek.mvvm_cli.login_module.model.LoginModel
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import junit.framework.TestCase
import org.junit.runner.RunWith
import org.junit.Test
import org.mockito.*

import org.mockito.Mockito.`when`
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog

/**
 * Created by Jianxin on 2021/2/1.
 */
@RunWith(RobolectricTestRunner::class)
class LoginViewModelTest : TestCase() {
    @Spy // mock it partially
    var loginModel: LoginModel = LoginModel(NetManager)

    private lateinit var mViewMode: LoginViewModel

    public override fun setUp() {
        System.out.println(System.currentTimeMillis())
//        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun testLogin() {
        ShadowLog.stream = System.out;
        MockitoAnnotations.openMocks(this)
        initRxJava2()
        println(System.currentTimeMillis())
        mViewMode = LoginViewModel(Application(), loginModel)
        whenever(loginModel.login("123", "456")).thenReturn(
            Single.error<LoginBean>(
                Throwable("报错报错")
            )
        )

        mViewMode.login("123", "456")
    }

    private fun initRxJava2() {
        RxJavaPlugins.reset()
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.reset()
        RxAndroidPlugins.setMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    private fun whenever(t: kotlin.Any?) = `when`(t)
}