package com.xxxxxx_yk.doucat.views.video

import android.net.Uri
import android.view.View
import android.view.Window
import android.view.WindowManager
import com.blankj.utilcode.util.LogUtils
import com.xxxxxx_yk.doucat.interfaces.GetVideoUrlListener
import com.xxxxxx_yk.doucat.model.LiveVideoUrl
import com.xxxxxx_yk.doucat.presenter.GetVideoUrlPresenter
import com.xxxxxx_yk.doucat.ui.ViewToKotlin.videoPlayerView
import com.xxxxxx_yk.doucat.utils.Constant
import com.xxxxxx_yk.doucat.utils.ViewID
import com.xxxxxx_yk.doucat.views.BaseActivity
import io.vov.vitamio.MediaPlayer
import io.vov.vitamio.Vitamio
import io.vov.vitamio.widget.MediaController
import io.vov.vitamio.widget.VideoView
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.toast


/**
 * Created by 惜梦哥哥 on 2018/3/1.
 */
class VideoPlayerActivity : BaseActivity(), GetVideoUrlListener {

    lateinit var videoPlayer: VideoView

    override fun initView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)//隐藏标题
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)//设置全屏
        Vitamio.isInitialized(applicationContext)
        relativeLayout {
            videoPlayer = videoPlayerView {
                id = ViewID.VIDEO_PLAYER
            }.lparams(width = matchParent, height = matchParent)
        }
    }

    override fun initListerenAndAdapter() {

    }

    override fun initData() {
        var room_id = intent.getStringExtra(Constant.ROOM_ID)
        LogUtils.e("RoomeID=" + room_id)
        var getVideoUrlPresenter = GetVideoUrlPresenter(room_id,this)
        getVideoUrlPresenter.loadDate()

        //测试连接,m3u8
//        videoPlayer.setVideoPath("http://cdn.can.cibntv.net/12/201702161000/rexuechangan01/rexuechangan01.m3u8")
    }

    override fun otherClick(v: View?) {
    }

    override fun getVideoUrlSuccess(liveData: LiveVideoUrl) {
        videoPlayer.setVideoPath(liveData.data.hlsUrl)
        videoPlayer.setBufferSize(1024 * 1024 * 2)
        videoPlayer.setVideoQuality(MediaPlayer.VIDEOQUALITY_HIGH)
        videoPlayer.requestFocus()
        videoPlayer.setOnPreparedListener {
            it.setPlaybackSpeed(1.0f)
        }
    }

    override fun getVideoUrlError(t: Throwable) {
        toast("网络错误")
    }

}