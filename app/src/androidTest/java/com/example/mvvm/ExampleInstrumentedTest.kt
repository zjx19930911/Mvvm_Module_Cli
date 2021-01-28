package com.example.mvvm

import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.robolectric.RobolectricTestRunner

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        Log.e("asdasd", System.currentTimeMillis().toString())
        Thread.sleep(1000)
        Log.e("asdasd", System.currentTimeMillis().toString())

        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.mvvm", appContext.packageName)
    }
}