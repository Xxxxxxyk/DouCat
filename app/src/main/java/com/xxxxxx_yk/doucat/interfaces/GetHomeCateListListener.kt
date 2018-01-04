package com.xxxxxx_yk.doucat.interfaces

import com.xxxxxx_yk.doucat.model.HomeCateList

/**
 * Created by 惜梦哥哥 on 2018/1/4.
 */
interface GetHomeCateListListener{
    fun showHomeCateListSuccess(homeCateList: HomeCateList)

    fun showHomeCateListError(t : Throwable)
}