package com.iflytek.commonlib.net

import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by Jianxin on 2021/1/7.
 */
object NetManager {
    private var retrofit: Retrofit?
    private const val url = "https://yxx.gaoshan.co";

    init {
        retrofit = Retrofit.Builder()
            .addConverterFactory(MyGsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(getNewClient())
            .baseUrl(url)
            .build();
    }

    fun <T> getService(service: Class<T>): T? {
        return retrofit?.create(service)
    }

    private fun getNewClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .cookieJar(object : CookieJar {
                //这里一定一定一定是HashMap<String, List<Cookie>>,是String,不是url.
                private val cookieStore =
                    HashMap<String, List<Cookie>>()

                override fun saveFromResponse(
                    url: HttpUrl,
                    cookies: List<Cookie>
                ) {
                    cookieStore[url.host()] = cookies
                }

                override fun loadForRequest(url: HttpUrl): List<Cookie> {
                    val cookies = cookieStore[url.host()]
                    return cookies ?: ArrayList()
                }
            })
            .addInterceptor(ChainInterceptor())
            .addInterceptor(LogInterceptor())
//            .addInterceptor(MockInterceptor("模拟滴数据"))
            .addInterceptor(MockInterceptor())
            .connectTimeout(30000, TimeUnit.MILLISECONDS)
            .readTimeout(30000, TimeUnit.MILLISECONDS)
            .build()
    }

}