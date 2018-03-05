package com.xxxxxx_yk.doucat.interfaces

import com.xxxxxx_yk.doucat.model.BestHot

/**
 * Created by 惜梦哥哥 on 2018/2/1.
 */
interface GetBestHotListener {
    fun getBestHotSuccess(bestHot : BestHot)

    fun getBestHotError(t: Throwable)
}