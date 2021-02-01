package com.iflytek.mvvm_cli

import android.app.Application
import com.iflytek.mvvm_cli.model.AppMainModel
import com.iflytek.mvvm_cli.viewmodel.AppMainViewModel
import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner


/**
 * Created by Jianxin on 2021/1/8.
 */
/**
 * 知识点1，runWith：RobolectricTestRunner
 * 表示测试时使用robolectric运行环境，可以测试Android代码，比如：textview.setText()这样的代码
 * 如果测试Presenter中没有涉及Android代码，则不要加，否则拖慢测试速度。
 */
@RunWith(RobolectricTestRunner::class)
class AppMainViewModelTest : TestCase() {
    private lateinit var mViewMode: AppMainViewModel
    @Mock
    lateinit var animal:AppMainModel
    @Mock
    var application: Application = Application()


    public override fun setUp() {
        System.out.println(System.currentTimeMillis())
        MockitoAnnotations.openMocks(this)
        mViewMode = AppMainViewModel(animal, application)
        // 初始化 @Mock 注解功能,自动注入 @Mock 标记的对象

    }
    @Test
    fun testShout() {
        initRxJava2()
        System.out.println(System.currentTimeMillis())
        MockitoAnnotations.openMocks(this)
        mViewMode = AppMainViewModel(animal, application)
        System.out.println(System.currentTimeMillis())

        mViewMode.shout()
        verify(mViewMode).info
//        Thread.sleep(10000)
    }
    private fun initRxJava2() {
        RxJavaPlugins.reset()
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.reset()
        RxAndroidPlugins.setMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

}