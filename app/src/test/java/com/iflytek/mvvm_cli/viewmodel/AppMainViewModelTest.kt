package com.iflytek.mvvm_cli.viewmodel

import android.app.Application
import com.iflytek.commonlib.database.dao.UserDao
import com.iflytek.commonlib.net.NetManager
import com.iflytek.mvvm_cli.TestApplication
import com.iflytek.mvvm_cli.login_module.bean.LoginBean
import com.iflytek.mvvm_cli.model.AppMainModel
import com.iflytek.mvvm_cli.viewmodel.AppMainViewModel
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.Mockito.any
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLog


/**
 * Created by Jianxin on 2021/1/8.
 */
/**
 * 知识点1，runWith：RobolectricTestRunner
 * 表示测试时使用robolectric运行环境，可以测试Android代码，比如：textview.setText()这样的代码
 * 如果测试Presenter中没有涉及Android代码，则不要加，否则拖慢测试速度。
 */
@RunWith(RobolectricTestRunner::class)
@Config(application = TestApplication::class)
class AppMainViewModelTest : TestCase() {
    @Mock
    lateinit var local: UserDao
    private lateinit var appMainModel: AppMainModel
    private lateinit var mViewMode: AppMainViewModel




    public override fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun testDetail() {
        ShadowLog.stream = System.out;//开log到控制台
        println(System.currentTimeMillis())
        MockitoAnnotations.openMocks(this)
        initRxJava2()
        appMainModel = AppMainModel(NetManager, local)
        whenever(local.getAllUser()).thenReturn(  Single.error<LoginBean>(
            Throwable("模拟数据库报错")
        ))
        mViewMode = AppMainViewModel(appMainModel, Application())
        println(System.currentTimeMillis())
        mViewMode.detail()
    }

    private fun initRxJava2() {
        RxJavaPlugins.reset()
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.reset()
        RxAndroidPlugins.setMainThreadSchedulerHandler { Schedulers.trampoline() }
    }
    private fun whenever(t: kotlin.Any?) = Mockito.`when`(t)
}