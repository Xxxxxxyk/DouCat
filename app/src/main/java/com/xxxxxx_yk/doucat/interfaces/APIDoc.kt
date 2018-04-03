package com.xxxxxx_yk.doucat.interfaces

import com.xxxxxx_yk.doucat.model.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

/**
 * Created by 惜梦哥哥 on 2018/1/4.
 */
interface APIDoc {

    @GET("/api/homeCate/getCateList")
    fun getHomeCateList(@QueryMap params: Map<String, String>): Observable<HomeCateList>

    @GET("/api/homeCate/getHotRoom")
    fun getOtherHomeCate(@QueryMap params: Map<String, String>) : Observable<HomeOtherCate>

    @GET("/api/v1/slide/6")
    fun getHomeBanners(@QueryMap params: Map<String, String>) : Observable<HomeBanners>

    @GET("/api/v1/getbigDataRoom")
    fun getBestHot(@QueryMap params: Map<String, String>) : Observable<BestHot>

    @GET("/html5/live")
    fun getVideoUrl(@QueryMap params: Map<String, String>) : Observable<LiveVideoUrl>

    @GET("/api/v1/getVerticalRoom")
    fun getVerticalRoom(@QueryMap params: Map<String, String>) : Observable<VerticalRoom>

}