package com.example.commonlib.net

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.ResponseBody
import okio.Buffer
import retrofit2.Converter
import retrofit2.Retrofit
import java.io.IOException
import java.io.OutputStreamWriter
import java.io.Writer
import java.lang.reflect.Type
import java.nio.charset.Charset

/**
 * Created by Jianxin on 2020/6/23.
 */
class MyGsonConverterFactory private constructor(gson: Gson?) : Converter.Factory() {
    private val gson: Gson
    override fun responseBodyConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *> {
        return MyGsonResponseBodyConverter<Any>(gson, type)
    }

    override fun requestBodyConverter(
        type: Type,
        parameterAnnotations: Array<Annotation>,
        methodAnnotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<*, RequestBody>? {
        return super.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit)
    }

    internal inner class MyGsonRequestBodyConverter<T>(
        private val gson: Gson,
        private val adapter: TypeAdapter<T>
    ) : Converter<T, RequestBody> {
        private val MEDIA_TYPE =
            MediaType.parse("application/json; charset=UTF-8")
        private val UTF_8 = Charset.forName("UTF-8")

        @Throws(IOException::class)
        override fun convert(value: T): RequestBody {
            val buffer = Buffer()
            val writer: Writer = OutputStreamWriter(buffer.outputStream(), UTF_8)
            val jsonWriter = gson.newJsonWriter(writer)
            adapter.write(jsonWriter, value)
            jsonWriter.close()
            return RequestBody.create(MEDIA_TYPE, buffer.readByteString())
        }

    }

    inner class MyGsonResponseBodyConverter<T> internal constructor(
        private val gson: Gson,
        private val type: Type
    ) : Converter<ResponseBody, T> {
        @Throws(IOException::class)
        override fun convert(value: ResponseBody): T {
            val response = value.string()
            value.use {
                val baseBean = gson.fromJson(response, BaseBean::class.java);//拦截code
                return if (baseBean.code != 200) {
                    gson.fromJson(gson.toJson(baseBean), type);
                } else {
                    gson.fromJson(response, type);
                }
            }
        }

    }

    companion object {
        /**
         * Create an instance using `gson` for conversion. Encoding to JSON and
         * decoding from JSON (when no charset is specified by a header) will use UTF-8.
         */
        /**
         * Create an instance using a default [Gson] instance for conversion. Encoding to JSON and
         * decoding from JSON (when no charset is specified by a header) will use UTF-8.
         */
        @JvmOverloads
        fun create(gson: Gson? = Gson()): MyGsonConverterFactory {
            return MyGsonConverterFactory(gson)
        }
    }

    init {
        if (gson == null) throw NullPointerException("gson == null")
        this.gson = gson
    }
}