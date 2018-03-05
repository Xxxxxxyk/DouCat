package com.xxxxxx_yk.doucat.views.video

import android.net.Uri
import android.view.View
import com.blankj.utilcode.util.LogUtils
import com.xxxxxx_yk.doucat.ui.ViewToKotlin.videoPlayerView
import com.xxxxxx_yk.doucat.views.BaseActivity
import io.vov.vitamio.widget.MediaController
import io.vov.vitamio.widget.VideoView
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.relativeLayout


/**
 * Created by 惜梦哥哥 on 2018/3/1.
 */
class VideoPlayerActivity : BaseActivity() {

    lateinit var videoPlayer: VideoView

    override fun initView() {
        relativeLayout {
            videoPlayer = videoPlayerView {
                id = ViewID.VIDEO_PLAYER
            }.lparams(width = matchParent, height = matchParent)
        }
    }

    override fun initListerenAndAdapter() {

    }

    override fun initData() {
        LogUtils.e("11111111111111111111111111111111111")
        videoPlayer.setVideoLayout(VideoView.VIDEO_LAYOUT_STRETCH, 0f)
        videoPlayer.setVideoURI(Uri.parse("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4"))
        videoPlayer.setMediaController(MediaController(this))

        videoPlayer.start()
    }

    override fun otherClick(v: View?) {
    }

}