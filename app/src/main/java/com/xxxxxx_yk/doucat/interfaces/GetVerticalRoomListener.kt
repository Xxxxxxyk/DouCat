package com.xxxxxx_yk.doucat.interfaces

import com.xxxxxx_yk.doucat.model.HomeOtherCate
import com.xxxxxx_yk.doucat.model.LiveData
import com.xxxxxx_yk.doucat.model.LiveVideoUrl
import com.xxxxxx_yk.doucat.model.VerticalRoom

/**
 * Created by 惜梦哥哥 on 2018/3/6.
 */
interface GetVerticalRoomListener {
    fun getVerticalRoomSuccess(verticalRoom : VerticalRoom)

    fun getVerticalRoomError(t : Throwable)
}