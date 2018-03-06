package com.xxxxxx_yk.doucat.services

import android.text.TextUtils
import com.blankj.utilcode.util.Utils
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import com.xxxxxx_yk.doucat.BuildConfig
import com.xxxxxx_yk.doucat.utils.Constant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Created by 惜梦哥哥_ on 2017/10/16.
 */
class RetrofitSingleton private constructor() {

    private var base_Url : String = Constant.BASE_URL

    companion object {
        fun get(): RetrofitSingleton {
            return getInstance.services
        }
    }

    object getInstance {
        var services = RetrofitSingleton()
    }

    fun setBaseUrl(url : String) : RetrofitSingleton{
        this.base_Url = url
        return this
    }


    fun initServices(): Retrofit {
        //设置超时时间,错误重连
        var builder = OkHttpClient.Builder()
                .readTimeout(8, TimeUnit.SECONDS)
                .writeTimeout(8, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .cookieJar(PersistentCookieJar(SetCookieCache(), SharedPrefsCookiePersistor(Utils.getApp())))

        //Debug模式下Log打印输出
        if (BuildConfig.DEBUG) {
            var httpLoggingInterceptor = HttpLoggingInterceptor()
            //设置打印等级
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
            builder.addInterceptor(httpLoggingInterceptor)
        }

        var interceptor = { chain: Interceptor.Chain ->
            var request = chain.request().newBuilder()
                    .build()
            chain.proceed(request)
        }

        builder.addInterceptor(interceptor)

        return Retrofit.Builder()
                .baseUrl(base_Url)
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}