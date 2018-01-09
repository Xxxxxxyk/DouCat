package com.xxxxxx_yk.doucat.interfaces

import com.xxxxxx_yk.doucat.model.HomeOtherCate

/**
 * Created by 惜梦哥哥 on 2018/1/9.
 */
interface GetOtherHomeCateListener {
    fun getOtherHomeCateSuccess(homeOtherCate: HomeOtherCate)

    fun getOtherHomeCateError(t : Throwable)
}