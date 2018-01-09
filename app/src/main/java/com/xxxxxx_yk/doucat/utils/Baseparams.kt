package com.xxxxxx_yk.doucat.utils

/**
 * Created by 惜梦哥哥 on 2018/1/8.
 */
object BaseParams {
    private var base_params = LinkedHashMap<String, String>()

    fun getBaseParams(): LinkedHashMap<String, String> {
        base_params.put("client_sys", "android")
        base_params.put("aid", "android1")
        base_params.put("time", System.currentTimeMillis().toString() + "")
        return base_params
    }
}