package com.xxxxxx_yk.doucat.application

import android.app.Application
import com.blankj.utilcode.util.Utils

/**
 * Created by 华农天时-Qiuzi on 2017/9/18.
 */
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Utils.init(this)
    }
}