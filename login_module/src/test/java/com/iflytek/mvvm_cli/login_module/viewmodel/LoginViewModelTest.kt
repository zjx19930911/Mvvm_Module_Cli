package com.iflytek.mvvm_cli.login_module.viewmodel

import android.app.Application
import com.iflytek.mvvm_cli.login_module.model.LoginModel
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import junit.framework.TestCase
import org.junit.runner.RunWith
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner

/**
 * Created by Jianxin on 2021/2/1.
 */
@RunWith(RobolectricTestRunner::class)
class LoginViewModelTest : TestCase() {
    private lateinit var mViewMode: LoginViewModel

    @Mock
    lateinit var loginModel: LoginModel

    @Mock
    var application: Application = Application()
    public override fun setUp() {
        super.setUp()
    }

    @Test
    fun testLogin() {
        initRxJava2()
        System.out.println(System.currentTimeMillis())
        MockitoAnnotations.openMocks(this)
        mViewMode = LoginViewModel(application, loginModel)
        System.out.println(System.currentTimeMillis())

        mViewMode.login("123", "456")
        verify(mViewMode).loginFailed

//        Thread.sleep(10000)
    }

    private fun initRxJava2() {
        RxJavaPlugins.reset()
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.reset()
        RxAndroidPlugins.setMainThreadSchedulerHandler { Schedulers.trampoline() }
    }
}