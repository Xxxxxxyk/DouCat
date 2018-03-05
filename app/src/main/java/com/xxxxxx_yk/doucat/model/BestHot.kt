package com.xxxxxx_yk.doucat.model
import com.google.gson.annotations.SerializedName


/**
 * Created by 惜梦哥哥 on 2018/2/1.
 */
data class BestHot(
		@SerializedName("error") var error: Int, //0
		@SerializedName("data") var data: List<Hot_Data>
)

data class Hot_Data(
		@SerializedName("specific_catalog") var specificCatalog: String,
		@SerializedName("vertical_src") var verticalSrc: String, //https://rpic.douyucdn.cn/amrpic-180201/639882_1714.jpg
		@SerializedName("rpos") var rpos: String, //10
		@SerializedName("hn") var hn: Int, //8522
		@SerializedName("game_name") var gameName: String, //其他手游
		@SerializedName("online") var online: String, //8522
		@SerializedName("avatar_small") var avatarSmall: String, //https://apic.douyucdn.cn/upload/avanew/face/201712/03/22/84b278159424f5b5de72fc5ff9cce941_small.jpg
		@SerializedName("avatar_mid") var avatarMid: String, //https://apic.douyucdn.cn/upload/avanew/face/201712/03/22/84b278159424f5b5de72fc5ff9cce941_middle.jpg
		@SerializedName("recomType") var recomType: String, //65
		@SerializedName("room_id") var roomId: String, //639882
		@SerializedName("src") var src: String, //0
		@SerializedName("show_time") var showTime: Int, //1517473956
		@SerializedName("show_status") var showStatus: Int, //1
		@SerializedName("ranktype") var ranktype: String, //106
		@SerializedName("nickname") var nickname: String, //节奏tempo
		@SerializedName("extra") var extra: String, //0
		@SerializedName("room_src") var roomSrc: String, //https://rpic.douyucdn.cn/amrpic-180201/639882_1714.jpg
		@SerializedName("cate_id") var cateId: String, //341
		@SerializedName("specific_status") var specificStatus: Int, //0
		@SerializedName("push_ios") var pushIos: Int, //1
		@SerializedName("vod_quality") var vodQuality: Int, //0
		@SerializedName("room_name") var roomName: String, //关注上车办卡插队，50VS50造起来
		@SerializedName("isVertical") var isVertical: Int, //0
		@SerializedName("jumpUrl") var jumpUrl: String,
		@SerializedName("push_nearby") var pushNearby: Int, //0
		@SerializedName("rmf1") var rmf1: Int, //0
		@SerializedName("rmf2") var rmf2: Int, //0
		@SerializedName("rmf3") var rmf3: Int, //0
		@SerializedName("rmf4") var rmf4: Int //0
) {
}