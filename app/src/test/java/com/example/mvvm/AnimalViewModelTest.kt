package com.example.mvvm

import android.app.Application
import com.example.mvvm.model.Animal
import com.example.mvvm.viewmodel.AnimalViewModel
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
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
class AnimalViewModelTest : TestCase() {
    private lateinit var mViewMode: AnimalViewModel
    @Mock
    lateinit var animal:Animal
    @Mock
    var application: Application = Application()


    public override fun setUp() {
        System.out.println(System.currentTimeMillis())
        MockitoAnnotations.openMocks(this)
        mViewMode = AnimalViewModel(animal, application)
        // 初始化 @Mock 注解功能,自动注入 @Mock 标记的对象

    }
    @Test
    fun testShout() {
        System.out.println(System.currentTimeMillis())
        MockitoAnnotations.openMocks(this)
        mViewMode = AnimalViewModel(animal, application)
        System.out.println(System.currentTimeMillis())

        mViewMode.shout()
//        verify(animal).shoutCount(anyString(), anyString())
        Thread.sleep(10000)
    }
}