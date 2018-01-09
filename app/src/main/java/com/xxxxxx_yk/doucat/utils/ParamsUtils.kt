package com.xxxxxx_yk.doucat.utils

/**
 * Created by 惜梦哥哥 on 2018/1/8.
 */
object ParamsUtils{

    var baseParams : LinkedHashMap<String , String>

    init {
        baseParams = BaseParams.getBaseParams()
    }

    fun getHomeCate(identification : String) : LinkedHashMap<String , String>{
        baseParams.put("identification",identification)
        return baseParams
    }

}



