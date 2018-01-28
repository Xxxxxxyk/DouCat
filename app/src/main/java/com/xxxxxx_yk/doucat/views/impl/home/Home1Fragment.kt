package com.xxxxxx_yk.doucat.views.impl.home

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.xxxxxx_yk.doucat.R
import com.xxxxxx_yk.doucat.interfaces.GetHomeBannerListener
import com.xxxxxx_yk.doucat.model.HomeBanners
import com.xxxxxx_yk.doucat.presenter.GetHomeBannerPresenter
import com.xxxxxx_yk.doucat.ui.HotBanner
import com.xxxxxx_yk.doucat.utils.GlideImageLoader
import com.xxxxxx_yk.doucat.views.BaseFragment
import com.xxxxxx_yk.doucat.views.adapter.HomeHotAdapter
import com.youth.banner.Banner
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.swipeRefreshLayout


/**
 * Created by 惜梦哥哥_ on 2017/10/16.
 */
class Home1Fragment : BaseFragment(), GetHomeBannerListener {

    var list = ArrayList<String>()
    private lateinit var recyclerView: RecyclerView
    private var hotAdapter = HomeHotAdapter(android.R.layout.simple_expandable_list_item_1, list)

    override fun initListeren() {

    }

    override fun initData() {
        var getHomeBannerPresenter = GetHomeBannerPresenter(this)
        getHomeBannerPresenter.loadDate()

        for (i in 0 until 101) {
            list.add(i.toString())
        }

        hotAdapter.notifyDataSetChanged()
    }

    override fun otherClick(v: View?) {
    }

    override fun getHomeBannerSuccess(homeBanners: HomeBanners) {
        var list = ArrayList<String>()
        for (banner in homeBanners.data) {
            list.add(banner.picUrl)
        }
        var banner = HotBanner.getHotBanner(context!!)
        banner.setImages(list).setImageLoader(GlideImageLoader()).start()
        hotAdapter.setHeaderView(banner)
    }

    override fun getHomeBannerError(t: Throwable) {
    }

    override fun createView(): View {
        return UI {
            relativeLayout {
                swipeRefreshLayout {
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