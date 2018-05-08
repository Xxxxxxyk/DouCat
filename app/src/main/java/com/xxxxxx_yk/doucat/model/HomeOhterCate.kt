package com.xxxxxx_yk.doucat.model
import com.google.gson.annotations.SerializedName


/**
 * Created by 惜梦哥哥 on 2018/1/9.
 */

data class HomeOtherCate(
		@SerializedName("error") var error: Int, //0
		@SerializedName("data") var data: List<HomeCateData>
)

data class HomeCateData(
		@SerializedName("room_list") var roomList: List<Hot_Data>,
		@SerializedName("tag_name") var tagName: String, //最热
		@SerializedName("tag_id") var tagId: String, //9
		@SerializedName("icon_url") var iconUrl: String,
		@SerializedName("small_icon_url") var smallIconUrl: String,
		@SerializedName("count") var count: Int, //2439
		@SerializedName("count_ios") var countIos: Int, //2260
		@SerializedName("push_vertical_screen") var pushVerticalScreen: Int //0
)

data class Room(
		@SerializedName("room_id") var roomId: String, //1229
		@SerializedName("room_src") var roomSrc: String, //https://rpic.douyucdn.cn/anrpic/180109/1229_1420.jpg
		@SerializedName("vertical_src") var verticalSrc: String, //https://rpic.douyucdn.cn/anrpic/180109/1229_1420.jpg
		@SerializedName("isVertical") var isVertical: Int, //0
		@SerializedName("cate_id") var cateId: Int, //181
		@SerializedName("room_name") var roomName: String, //【嗨氏】暂改为白天10-18点直播
		@SerializedName("show_status") var showStatus: String, //1
		@SerializedName("subject") var subject: String,
		@SerializedName("show_time") var showTime: String, //1515465010
		@SerializedName("owner_uid") var ownerUid: String, //62936
		@SerializedName("nickname") var nickname: String, //嗨氏
		@SerializedName("hn") var hn: Int, //0
		@SerializedName("online") var online: Int, //0
		@SerializedName("game_name") var gameName: String, //王者荣耀
		@SerializedName("child_id") var childId: Int, //224
		@SerializedName("avatar_mid") var avatarMid: String, //https://apic.douyucdn.cn/upload/avanew/face/201711/09/01/bcecb258b9ca1c04aad6cf566e8849a1_middle.jpg
		@SerializedName("avatar_small") var avatarSmall: String, //https://apic.douyucdn.cn/upload/avanew/face/201711/09/01/bcecb258b9ca1c04aad6cf566e8849a1_small.jpg
		@SerializedName("jumpUrl") var jumpUrl: String,
		@SerializedName("icon_data") var iconData: IconData,
		@SerializedName("rmf1") var rmf1: Int, //0
		@SerializedName("rmf2") var rmf2: Int //0
)

data class IconData(
		@SerializedName("status") var status: Int, //4
		@SerializedName("icon_url") var iconUrl: String, //https://club-img.douyucdn.cn/dylamr/2017/10/31/af52ad1ab8261e54608ea94e48577013.png
		@SerializedName("icon_width") var iconWidth: String, //126
		@SerializedName("icon_height") var iconHeight: String //33
)