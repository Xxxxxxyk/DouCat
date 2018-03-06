package com.xxxxxx_yk.doucat.model
import com.google.gson.annotations.SerializedName


/**
 * Created by 惜梦哥哥 on 2018/3/6.
 */

data class LiveVideoUrl(
		@SerializedName("error") var error: Int, //0
		@SerializedName("data") var data: LiveData
)

data class LiveData(
		@SerializedName("hls_url") var hlsUrl: String //http://hls3a.douyucdn.cn/live/2248544rjVgyDdYV_550/playlist.m3u8?wsSecret=e95169ba7b6b763f92808c2ea96d5fba&wsTime=1520302693&token=h5-douyu-0-2248544-5bb99871c950a171efe88a8af1d0042e&did=h5_did
)