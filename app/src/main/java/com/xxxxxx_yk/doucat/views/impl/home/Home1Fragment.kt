package com.xxxxxx_yk.doucat.views.impl.home

import android.content.Intent
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.GridLayoutHelper
import com.alibaba.android.vlayout.layout.LinearLayoutHelper
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.SnackbarUtils
import com.xxxxxx_yk.doucat.R
import com.xxxxxx_yk.doucat.interfaces.*
import com.xxxxxx_yk.doucat.model.BestHot
import com.xxxxxx_yk.doucat.model.HomeBanners
import com.xxxxxx_yk.doucat.model.HomeCate
import com.xxxxxx_yk.doucat.model.VerticalRoom
import com.xxxxxx_yk.doucat.presenter.GetBestHotPresenter
import com.xxxxxx_yk.doucat.presenter.GetHomeBannerPresenter
import com.xxxxxx_yk.doucat.presenter.GetHomeCatePresenter
import com.xxxxxx_yk.doucat.presenter.GetVerticalRoomPresenter
import com.xxxxxx_yk.doucat.utils.Constant
import com.xxxxxx_yk.doucat.views.BaseFragment
import com.xxxxxx_yk.doucat.views.adapter.BestHomeHotAdapter
import com.xxxxxx_yk.doucat.views.adapter.FaceAdapter
import com.xxxxxx_yk.doucat.views.adapter.MainBannerAdapter
import com.xxxxxx_yk.doucat.views.adapter.MainTitleAdapter
import com.xxxxxx_yk.doucat.views.video.VideoPlayerActivity
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.dip
import org.jetbrains.anko.support.v4.swipeRefreshLayout


/**
 * Created by 惜梦哥哥_ on 2017/10/16.
 */
class Home1Fragment : BaseFragment(), GetHomeBannerListener, GetBestHotListener, GetVerticalRoomListener, GetHomeCateListener {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mSrl: SwipeRefreshLayout
    private lateinit var rl: RelativeLayout
    private lateinit var getHomeBannerPresenter: GetHomeBannerPresenter
    private lateinit var getBestHotPresenter: GetBestHotPresenter
    private lateinit var getVerticalRoomPresenter: GetVerticalRoomPresenter
    private lateinit var getHomeCatePresenter: GetHomeCatePresenter
    private lateinit var mLayoutManager: VirtualLayoutManager
    private lateinit var mDelegateAdapter: DelegateAdapter
    private var adapters = ArrayList<DelegateAdapter.Adapter<RecyclerView.ViewHolder>>()

    override fun initListerenAndAdapter() {
        mLayoutManager = VirtualLayoutManager(context!!)
        mRecyclerView.layoutManager = mLayoutManager

        var recyclerPool = RecyclerView.RecycledViewPool()
        recyclerPool.setMaxRecycledViews(0, 20)
        mRecyclerView.recycledViewPool = recyclerPool

        mDelegateAdapter = DelegateAdapter(mLayoutManager, true)
        mRecyclerView.adapter = mDelegateAdapter

        mSrl.setColorSchemeColors(resources.getColor(R.color.colorPrimary))
        mSrl.setOnRefreshListener {
            adapters.clear()
            initData()
        }
    }

    override fun initData() {

        mSrl.isRefreshing = true
        //获取轮播图数据
        getHomeBannerPresenter = GetHomeBannerPresenter(this)
        getHomeBannerPresenter.loadDate()


    }

    override fun otherClick(v: View?) {

    }

    override fun getHomeBannerSuccess(homeBanners: HomeBanners) {
        adapters.add(MainBannerAdapter(homeBanners, context!!, LinearLayoutHelper(), 1))
        adapters.add(MainTitleAdapter("最热", context!!, LinearLayoutHelper(), 1, VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dip(40))))
        mDelegateAdapter.notifyDataSetChanged()

        //获取首页最热数据
        getBestHotPresenter = GetBestHotPresenter(this)
        getBestHotPresenter.loadDate()
        mSrl.isRefreshing = false
    }

    override fun getHomeBannerError(t: Throwable) {
        mSrl.isRefreshing = false
        SnackbarUtils.with(rl).setMessage("网络连接超时...")
        t.printStackTrace()
    }

    override fun getBestHotSuccess(bestHot: BestHot) {
        LogUtils.e(bestHot.toString())
        adapters.add(BestHomeHotAdapter(context!!, bestHot.data, GridLayoutHelper(2), 8))
        adapters.add(MainTitleAdapter("颜值", context!!, LinearLayoutHelper(), 1, VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dip(40))))
        getVerticalRoomPresenter = GetVerticalRoomPresenter(this)
        getVerticalRoomPresenter.loadDate()
        mDelegateAdapter.notifyDataSetChanged()
        mSrl.isRefreshing = false
    }

    override fun getBestHotError(t: Throwable) {
        t.printStackTrace()
        mSrl.isRefreshing = false
    }

    override fun getVerticalRoomSuccess(verticalRoom: VerticalRoom) {
        adapters.add(FaceAdapter(context!!, verticalRoom.data, GridLayoutHelper(2), 4))
        getHomeCatePresenter = GetHomeCatePresenter(this)
        getHomeCatePresenter.loadDate()
        mSrl.isRefreshing = false
    }

    override fun getVerticalRoomError(t: Throwable) {
        mSrl.isRefreshing = false
    }

    override fun getHomeCateSuccess(homecate: HomeCate) {
        LogUtils.e(homecate)
        for (room_list in homecate.data) {
            adapters.add(MainTitleAdapter(room_list.tagName, context!!, LinearLayoutHelper(), 1, VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dip(40))))
            adapters.add(BestHomeHotAdapter(context!!, room_list.roomList, GridLayoutHelper(2), room_list.roomList.size))
        }
        mDelegateAdapter.setAdapters(adapters)
        mSrl.isRefreshing = false
    }

    override fun getHomeCateError(t: Throwable) {
        t.printStackTrace()
        mSrl.isRefreshing = false
    }


    override fun createView(): View {
        return UI {
            rl = relativeLayout {
                mSrl = swipeRefreshLayout {
                    mRecyclerView = recyclerView {

                    }
                }.lparams(width = matchParent, height = matchParent)
            }
        }.view
    }
}