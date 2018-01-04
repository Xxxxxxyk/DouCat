package com.xxxxxx_yk.doucat.interfaces

import com.xxxxxx_yk.doucat.model.HomeCateList
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Created by 惜梦哥哥 on 2018/1/4.
 */
interface APIDoc {

    @GET("/api/homeCate/getCateList")
    fun getHomeCateList(): Observable<HomeCateList>

}