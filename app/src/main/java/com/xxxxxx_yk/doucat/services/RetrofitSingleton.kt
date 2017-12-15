package com.xxxxxx_yk.doucat.services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by 华农天时-Qiuzi on 2017/10/16.
 */
class RetrofitSingleton private constructor(){

    private var logging : HttpLoggingInterceptor = HttpLoggingInterceptor()

    companion object {
        fun get() : RetrofitSingleton {
            return getInstance.services
        }
    }

    object getInstance{
        var services = RetrofitSingleton()
    }

    fun initServices(): Retrofit{
        //设置超时时间,错误重连
        var builder = OkHttpClient.Builder()
                .readTimeout(8,TimeUnit.SECONDS)
                .writeTimeout(8,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(logging)

        return Retrofit.Builder()
                .baseUrl("")
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}