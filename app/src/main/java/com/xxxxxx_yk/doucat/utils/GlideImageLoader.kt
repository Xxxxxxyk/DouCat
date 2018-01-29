package com.xxxxxx_yk.doucat.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.request.RequestOptions
import com.xxxxxx_yk.doucat.R
import com.xxxxxx_yk.doucat.application.GlideApp
import com.youth.banner.loader.ImageLoader


/**
 * Created by 惜梦哥哥 on 2018/1/26.
 */
class GlideImageLoader : ImageLoader() {
    override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
        GlideApp.with(context)
                .load(path)
                .placeholder(R.mipmap.image_banner_loading)
                .fitCenter()
                .into(imageView);
    }
}