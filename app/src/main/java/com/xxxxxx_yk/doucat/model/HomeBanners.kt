package com.xxxxxx_yk.doucat.model
import com.google.gson.annotations.SerializedName


/**
 * Created by 惜梦哥哥 on 2018/1/26.
 */

data class HomeBanners(
		@SerializedName("error") var error: Int, //0
		@SerializedName("data") var data: List<Data>
)

data class Data(
		@SerializedName("id") var id: Int, //156332
		@SerializedName("main_id") var mainId: Int, //38148
		@SerializedName("source") var source: Int, //2
		@SerializedName("oa_source") var oaSource: Int, //21
		@SerializedName("title") var title: String, //EVO JAPAN2018
		@SerializedName("pic_url") var picUrl: String, //https://staticlive.douyucdn.cn/storage/webpic_resources/upload/slide/2018/0118/201801181741357276.png
		@SerializedName("tv_pic_url") var tvPicUrl: String, //https://staticlive.douyucdn.cn/storage/webpic_resources/upload/slide/2018/0118/201801181741427505.png
		@SerializedName("room") var room: RoomInfo
)

data class RoomInfo(
		@SerializedName("room_id") var roomId: String, //156332
		@SerializedName("room_src") var roomSrc: String, //https://rpic.douyucdn.cn/amrpic-180126/156332_1055.jpg
		@SerializedName("vertical_src") var verticalSrc: String, //https://rpic.douyucdn.cn/amrpic-180126/156332_1055.jpg
		@SerializedName("isVertical") var isVertical: Int, //0
		@SerializedName("cate_id") var cateId: String, //29
		@SerializedName("room_name") var roomName: String, //【斗鱼官方】EVO JAPAN第一天赛事
		@SerializedName("vod_quality") var vodQuality: String, //0
		@SerializedName("show_status") var showStatus: String, //1
		@SerializedName("show_time") var showTime: String, //1516887877
		@SerializedName("owner_uid") var ownerUid: String, //59592
		@SerializedName("specific_catalog") var specificCatalog: String, //qqarc
		@SerializedName("specific_status") var specificStatus: String, //1
		@SerializedName("credit_illegal") var creditIllegal: String, //0
		@SerializedName("is_white_list") var isWhiteList: String, //0
		@SerializedName("cur_credit") var curCredit: String, //12
		@SerializedName("low_credit") var lowCredit: String, //4
		@SerializedName("online") var online: Int, //2372
		@SerializedName("nickname") var nickname: String, //QQ游戏街机
		@SerializedName("url") var url: String, ///qqarc
		@SerializedName("game_url") var gameUrl: String, ///directory/game/FTG
		@SerializedName("game_name") var gameName: String, //格斗游戏
		@SerializedName("game_icon_url") var gameIconUrl: String, //https://staticlive.douyucdn.cn/upload/game_cate/d014202049bb30994b1462714507cd8e.jpg
		@SerializedName("show_details") var showDetails: String, //QQ群28123569，有什么问题欢迎来咨询哦
		@SerializedName("owner_avatar") var ownerAvatar: String, //https://apic.douyucdn.cn/upload/avatar/000/05/95/92_avatar_big.jpg?rltime?rltime
		@SerializedName("cdnsWithName") var cdnsWithName: List<CdnsWithName>,
		@SerializedName("is_pass_player") var isPassPlayer: Int, //0
		@SerializedName("open_full_screen") var openFullScreen: Int, //0
		@SerializedName("owner_weight") var ownerWeight: String, //2.45t
		@SerializedName("fans") var fans: String, //61003
		@SerializedName("is_high_game") var isHighGame: Int, //1
		@SerializedName("column_id") var columnId: String, //15
		@SerializedName("cate_limit") var cateLimit: CateLimit
)

data class CdnsWithName(
		@SerializedName("name") var name: String, //主线路
		@SerializedName("cdn") var cdn: String //ws
)

data class CateLimit(
		@SerializedName("limit_type") var limitType: Int, //0
		@SerializedName("limit_num") var limitNum: Int, //0
		@SerializedName("limit_threshold") var limitThreshold: Int, //0
		@SerializedName("limit_time") var limitTime: Int //0
)