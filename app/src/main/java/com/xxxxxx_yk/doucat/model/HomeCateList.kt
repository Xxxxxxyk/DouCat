package com.xxxxxx_yk.doucat.model

import com.google.gson.annotations.SerializedName


/**
 * Created by 惜梦哥哥 on 2018/1/4.
 */
data class HomeCateList(
        @SerializedName("error") var error: Int, //0
        @SerializedName("data") var data: List<Data>
)

data class Data(
        @SerializedName("title") var title: String, //手游
        @SerializedName("show_order") var showOrder: String, //1
        @SerializedName("identification") var identification: String, //3e760da75be261a588c74c4830632360
        @SerializedName("is_video") var isVideo: Int, //0
        @SerializedName("is_show_cate1_icon") var isShowCate1Icon: Int //0
)