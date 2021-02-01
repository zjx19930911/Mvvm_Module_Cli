package com.iflytek.mvvm_cli

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        System.out.println(System.currentTimeMillis())
        Thread.sleep(1000);
        System.out.println(System.currentTimeMillis())
        assertEquals(4, 2 + 2)
    }
}