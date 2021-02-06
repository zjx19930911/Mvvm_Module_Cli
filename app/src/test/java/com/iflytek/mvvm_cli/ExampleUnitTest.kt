package com.iflytek.mvvm_cli

import com.iflytek.commonlib.net.NetManager
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
@Config(application = TestApplication::class)
class ExampleUnitTest {

    @Mock
    lateinit var net: NetManager

    @Test
    fun addition_isCorrect() {
        System.out.println(System.currentTimeMillis())
        MockitoAnnotations.openMocks(this)
        Thread.sleep(1000);
        System.out.println(System.currentTimeMillis())
        assertEquals(4, 2 + 2)
    }
}