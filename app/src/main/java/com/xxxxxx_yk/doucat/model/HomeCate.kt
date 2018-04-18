package com.xxxxxx_yk.doucat.model
import com.google.gson.annotations.SerializedName


data class HomeCate(
		@SerializedName("error") var error: Int, //0
		@SerializedName("data") var data: List<Room_Data>
)

data class Room_Data(
		@SerializedName("room_list") var roomList: List<Hot_Data>,
		@SerializedName("push_vertical_screen") var pushVerticalScreen: String, //0
		@SerializedName("icon_url") var iconUrl: String, //https://cs-op.douyucdn.cn/dycatr/game_cate/d3e0073bfb714186ab0c818744601963.jpg
		@SerializedName("small_icon_url") var smallIconUrl: String, //https://cs-op.douyucdn.cn/dycatr/game_cate/ffdc72ed97b50ad8011de9a779b8d83b.png
		@SerializedName("push_nearby") var pushNearby: String, //0
		@SerializedName("tag_name") var tagName: String, //英雄联盟
		@SerializedName("tag_id") var tagId: String //1
)
