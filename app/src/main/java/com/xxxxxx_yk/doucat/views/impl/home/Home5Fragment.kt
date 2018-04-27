package com.xxxxxx_yk.doucat.views.impl.home

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.GridLayoutHelper
import com.alibaba.android.vlayout.layout.LinearLayoutHelper
import com.xxxxxx_yk.doucat.R
import com.xxxxxx_yk.doucat.interfaces.GetOtherHomeCateListener
import com.xxxxxx_yk.doucat.model.HomeCateListData
import com.xxxxxx_yk.doucat.model.HomeOtherCate
import com.xxxxxx_yk.doucat.presenter.GetOtherHomeCatePresenter
import com.xxxxxx_yk.doucat.utils.Constant
import com.xxxxxx_yk.doucat.views.BaseFragment
import com.xxxxxx_yk.doucat.views.adapter.BestHomeHotAdapter
import com.xxxxxx_yk.doucat.views.adapter.MainTitleAdapter
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.dip
import org.jetbrains.anko.support.v4.swipeRefreshLayout
import org.jetbrains.anko.textView

/**
 * Created by 惜梦哥哥_ on 2017/10/16.
 */
class Home5Fragment : BaseFragment(), GetOtherHomeCateListener {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mSrl: SwipeRefreshLayout
    private lateinit var rl: RelativeLayout
    private lateinit var mBundle: HomeCateListData
    private lateinit var mHomeOhterCate: HomeOtherCate
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
        mBundle = arguments!!.getSerializable(Constant.HOME_CATE_LIST) as HomeCateListData
        var getOtherHomeCatePresenter = GetOtherHomeCatePresenter(this, mBundle.identification)
        getOtherHomeCatePresenter.loadDate()
    }

    override fun otherClick(v: View?) {
    }

    override fun getOtherHomeCateSuccess(homeOtherCate: HomeOtherCate) {
        this.mHomeOhterCate = homeOtherCate
        for (homeOtherData in homeOtherCate.data) {
            adapters.add(MainTitleAdapter(homeOtherData.tagName, context!!, LinearLayoutHelper(), 1, VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dip(40))))
            adapters.add(BestHomeHotAdapter(context!!, homeOtherData.roomList, GridLayoutHelper(2), homeOtherData.roomList.size))
        }
        mDelegateAdapter.setAdapters(adapters)
    }

    override fun getOtherHomeCateError(t: Throwable) {
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