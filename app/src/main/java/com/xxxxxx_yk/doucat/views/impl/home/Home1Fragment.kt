package com.xxxxxx_yk.doucat.views.impl.home

import android.content.Intent
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.RelativeLayout
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.SnackbarUtils
import com.jcodecraeer.xrecyclerview.XRecyclerView
import com.xxxxxx_yk.doucat.R
import com.xxxxxx_yk.doucat.interfaces.GetBestHotListener
import com.xxxxxx_yk.doucat.interfaces.GetHomeBannerListener
import com.xxxxxx_yk.doucat.interfaces.GetVerticalRoomListener
import com.xxxxxx_yk.doucat.model.BestHot
import com.xxxxxx_yk.doucat.model.HomeBanners
import com.xxxxxx_yk.doucat.model.Hot_Data
import com.xxxxxx_yk.doucat.model.VerticalRoom
import com.xxxxxx_yk.doucat.presenter.GetBestHotPresenter
import com.xxxxxx_yk.doucat.presenter.GetHomeBannerPresenter
import com.xxxxxx_yk.doucat.presenter.GetVerticalRoomPresenter
import com.xxxxxx_yk.doucat.ui.HotBanner
import com.xxxxxx_yk.doucat.ui.ViewToKotlin.xRecyclerView
import com.xxxxxx_yk.doucat.utils.Constant
import com.xxxxxx_yk.doucat.views.BaseFragment
import com.xxxxxx_yk.doucat.views.adapter.HomeHotAdapter
import com.xxxxxx_yk.doucat.views.video.VideoPlayerActivity
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.swipeRefreshLayout


/**
 * Created by 惜梦哥哥_ on 2017/10/16.
 */
class Home1Fragment : BaseFragment(), GetHomeBannerListener, GetBestHotListener, GetVerticalRoomListener {

    private lateinit var xRecyclerView: XRecyclerView
    private lateinit var rl: RelativeLayout
    private lateinit var getHomeBannerPresenter : GetHomeBannerPresenter
    private lateinit var getBestHotPresenter : GetBestHotPresenter
    private var hotAdapter = HomeHotAdapter()


    override fun initListerenAndAdapter() {
        hotAdapter.setContext(context!!)
        xRecyclerView.setLoadingListener(object : XRecyclerView.LoadingListener{
            override fun onLoadMore() {
                xRecyclerView.loadMoreComplete();
            }

            override fun onRefresh() {
                //获取首页最热数据
                getBestHotPresenter = GetBestHotPresenter(this@Home1Fragment)
                getBestHotPresenter.loadDate()

                var getVerticalRoomPresenter = GetVerticalRoomPresenter(this@Home1Fragment)
                getVerticalRoomPresenter.loadDate()
            }
        })
    }

    override fun initData() {

        //获取轮播图数据
        getHomeBannerPresenter = GetHomeBannerPresenter(this)
        getHomeBannerPresenter.loadDate()

        //获取首页最热数据
        getBestHotPresenter = GetBestHotPresenter(this)
        getBestHotPresenter.loadDate()

        var getVerticalRoomPresenter = GetVerticalRoomPresenter(this)
        getVerticalRoomPresenter.loadDate()
    }

    override fun otherClick(v: View?) {

    }

    override fun getHomeBannerSuccess(homeBanners: HomeBanners) {
        var list = ArrayList<String>()
        for (banner in homeBanners.data) {
            list.add(banner.picUrl)
        }

        var hotBanner = HotBanner(list)
        var hotBannerView = hotBanner.getHotBanner(context!!)
        hotBanner.start()

        hotBanner.setOnBannerListener { position ->
            var intent = Intent(context,VideoPlayerActivity::class.java)
            intent.putExtra(Constant.ROOM_ID,homeBanners.data.get(position).room.roomId)
            startActivity(intent)
        }
        xRecyclerView.addHeaderView(hotBannerView)
    }

    override fun getHomeBannerError(t: Throwable) {
        SnackbarUtils.with(rl).setMessage("网络连接超时...")
        t.printStackTrace()
    }

    override fun getBestHotSuccess(bestHot: BestHot) {
        LogUtils.e(bestHot.toString())
        hotAdapter.getHotData(bestHot.data)
        hotAdapter.notifyDataSetChanged()
        xRecyclerView.refreshComplete()
    }

    override fun getBestHotError(t: Throwable) {
        t.printStackTrace()
        xRecyclerView.refreshComplete()
    }

    override fun getVerticalRoomSuccess(verticalRoom: VerticalRoom) {
        hotAdapter.getFaceData(verticalRoom.data)
        hotAdapter.notifyDataSetChanged()
        xRecyclerView.refreshComplete()
    }

    override fun getVerticalRoomError(t: Throwable) {
        xRecyclerView.refreshComplete()
    }

    override fun createView(): View {
        return UI {
            rl = relativeLayout {
                    xRecyclerView = xRecyclerView {
                        layoutManager = LinearLayoutManager(context)
                        adapter = hotAdapter
                }.lparams(width = matchParent, height = matchParent)
            }
        }.view
    }
}