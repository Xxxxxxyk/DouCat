package com.xxxxxx_yk.doucat.views.impl.home

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.RelativeLayout
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.SnackbarUtils
import com.xxxxxx_yk.doucat.R
import com.xxxxxx_yk.doucat.interfaces.GetBestHotListener
import com.xxxxxx_yk.doucat.interfaces.GetHomeBannerListener
import com.xxxxxx_yk.doucat.model.BestHot
import com.xxxxxx_yk.doucat.model.HomeBanners
import com.xxxxxx_yk.doucat.presenter.GetBestHotPresenter
import com.xxxxxx_yk.doucat.presenter.GetHomeBannerPresenter
import com.xxxxxx_yk.doucat.ui.HotBanner
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
class Home1Fragment : BaseFragment(), GetHomeBannerListener, GetBestHotListener {


    var list_num = ArrayList<String>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var rl: RelativeLayout
    private lateinit var swipeRefreshLayout : SwipeRefreshLayout
    private lateinit var getHomeBannerPresenter : GetHomeBannerPresenter
    private lateinit var getBestHotPresenter : GetBestHotPresenter
    private var hotAdapter = HomeHotAdapter(android.R.layout.simple_expandable_list_item_1, list_num)

    override fun initListerenAndAdapter() {
        swipeRefreshLayout.setOnRefreshListener {  initData()  }
    }

    override fun initData() {

        //获取轮播图数据
        getHomeBannerPresenter = GetHomeBannerPresenter(this)
        getHomeBannerPresenter.loadDate()

        //获取首页最热数据
        getBestHotPresenter = GetBestHotPresenter(this)
        getBestHotPresenter.loadDate()
        swipeRefreshLayout.isRefreshing = true
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

        hotBanner.setOnBannerListener {
            startActivity<VideoPlayerActivity>()
        }
        hotAdapter.setHeaderView(hotBannerView)
        swipeRefreshLayout.isRefreshing = false
    }

    override fun getHomeBannerError(t: Throwable) {
        swipeRefreshLayout.isRefreshing = false
        SnackbarUtils.with(rl).setMessage("网络连接超时...")
        t.printStackTrace()
    }

    override fun getBestHotSuccess(bestHot: BestHot) {
        LogUtils.e(bestHot.toString())
    }

    override fun getBestHotError(t: Throwable) {
        SnackbarUtils.with(rl).setMessage("网络连接超时...")
    }

    override fun createView(): View {
        return UI {
            rl = relativeLayout {
                swipeRefreshLayout = swipeRefreshLayout {
                    setColorSchemeColors(resources.getColor(R.color.colorPrimary))
                    recyclerView = recyclerView {
                        layoutManager = LinearLayoutManager(context)
                        adapter = hotAdapter
                    }
                }.lparams(width = matchParent, height = matchParent)
            }
        }.view
    }
}