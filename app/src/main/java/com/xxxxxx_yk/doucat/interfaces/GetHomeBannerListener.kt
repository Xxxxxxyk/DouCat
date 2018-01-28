package com.xxxxxx_yk.doucat.interfaces

import com.xxxxxx_yk.doucat.model.HomeBanners

/**
 * Created by 惜梦哥哥 on 2018/1/26.
 */
interface GetHomeBannerListener {
    fun getHomeBannerSuccess(homeBanners: HomeBanners)

    fun getHomeBannerError(t: Throwable)
}