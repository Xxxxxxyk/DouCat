package com.xxxxxx_yk.doucat.application

import android.app.Application
import com.blankj.utilcode.util.Utils
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule

/**
 * Created by 惜梦哥哥_ on 2017/9/18.
 */
class DouCat_App : Application() {

    override fun onCreate() {
        super.onCreate()
        Utils.init(this)
    }
}

@GlideModule
class MyAppGlideModule : AppGlideModule() {}
