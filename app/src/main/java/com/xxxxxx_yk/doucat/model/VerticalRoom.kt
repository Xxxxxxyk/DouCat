package com.xxxxxx_yk.doucat.model
import com.google.gson.annotations.SerializedName


/**
 * Created by 惜梦哥哥 on 2018/3/30.
 */

data class VerticalRoom(
		@SerializedName("error") var error: Int, //0
		@SerializedName("data") var data: List<VerticalData>
)

data class VerticalData(
		@SerializedName("room_id") var roomId: String, //3559600
		@SerializedName("room_src") var roomSrc: String, //https://rpic.douyucdn.cn/live-cover/appCovers/2018/03/01/3559600_20180301211036_small.jpg
		@SerializedName("vertical_src") var verticalSrc: String, //https://rpic.douyucdn.cn/live-cover/appCovers/2018/03/01/3559600_20180301211036_big.jpg
		@SerializedName("isVertical") var isVertical: Int, //1
		@SerializedName("cate_id") var cateId: Int, //201
		@SerializedName("room_name") var roomName: String, //我在这喧嚣中把你寻找 孤独人的美丽谎言
		@SerializedName("show_status") var showStatus: String, //1
		@SerializedName("subject") var subject: String,
		@SerializedName("show_time") var showTime: String, //1522389022
		@SerializedName("owner_uid") var ownerUid: String, //174309362
		@SerializedName("specific_catalog") var specificCatalog: String,
		@SerializedName("specific_status") var specificStatus: String, //0
		@SerializedName("vod_quality") var vodQuality: String, //0
		@SerializedName("nickname") var nickname: String, //wuli美寶没钱怼
		@SerializedName("hn") var hn: Int, //0
		@SerializedName("online") var online: Int, //0
		@SerializedName("game_name") var gameName: String, //颜值
		@SerializedName("child_id") var childId: Int, //581
		@SerializedName("avatar_mid") var avatarMid: String, //https://apic.douyucdn.cn/upload/avanew/face/201803/24/02/68debea91f07d9e9fd405edb293364eb_middle.jpg
		@SerializedName("avatar_small") var avatarSmall: String, //https://apic.douyucdn.cn/upload/avanew/face/201803/24/02/68debea91f07d9e9fd405edb293364eb_small.jpg
		@SerializedName("jumpUrl") var jumpUrl: String,
		@SerializedName("nrt") var nrt: Int, //0
		@SerializedName("ranktype") var ranktype: Int, //0
		@SerializedName("rmf1") var rmf1: Int, //0
		@SerializedName("rmf2") var rmf2: Int, //0
		@SerializedName("rmf3") var rmf3: Int, //0
		@SerializedName("rmf4") var rmf4: Int, //0
		@SerializedName("show_type") var showType: Int, //0
		@SerializedName("is_noble_rec") var isNobleRec: Int, //0
		@SerializedName("anchor_city") var anchorCity: String //福州市
)