package com.xxxxxx_yk.doucat.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.youth.banner.loader.ImageLoader
import com.bumptech.glide.request.RequestOptions
import com.xxxxxx_yk.doucat.R


/**
 * Created by 惜梦哥哥 on 2018/1/26.
 */
class GlideImageLoader : ImageLoader() {
    override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
        Glide.with(context)
                .load(path)
                .apply(RequestOptions().placeholder(R.mipmap.image_banner_loading).centerCrop())
                .into(imageView);
    }
}