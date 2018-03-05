package com.xxxxxx_yk.doucat.interfaces

import com.xxxxxx_yk.doucat.model.BestHot
import com.xxxxxx_yk.doucat.model.HomeBanners
import com.xxxxxx_yk.doucat.model.HomeCateList
import com.xxxxxx_yk.doucat.model.HomeOtherCate
import io.reactivex.Observable
import retrofit2.http.GET
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

}