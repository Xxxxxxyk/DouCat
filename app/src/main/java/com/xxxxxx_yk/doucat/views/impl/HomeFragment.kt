package com.xxxxxx_yk.doucat.views.impl

import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.View
import com.github.kimkevin.slidingicontablayout.wigets.SlidingIconTabLayout
import com.xxxxxx_yk.doucat.R
import com.xxxxxx_yk.doucat.interfaces.GetHomeCateListListener
import com.xxxxxx_yk.doucat.model.HomeCateList
import com.xxxxxx_yk.doucat.presenter.GetHomeCateListPresenter
import com.xxxxxx_yk.doucat.ui.ViewToKotlin.slidingIconTabLayout
import com.xxxxxx_yk.doucat.utils.ViewID
import com.xxxxxx_yk.doucat.views.BaseFragment
import com.xxxxxx_yk.doucat.views.adapter.HomeAdapter
import com.xxxxxx_yk.doucat.views.impl.home.*
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.viewPager
import org.jetbrains.anko.verticalLayout

/**
 * Created by 华农天时-Qiuzi on 2017/9/25.
 */
class HomeFragment : BaseFragment(), GetHomeCateListListener {

    var isPrepared: Boolean = false
    var mHasLoadedOnce: Boolean = false
    var list: ArrayList<Fragment> = ArrayList<Fragment>()
    var vp: ViewPager? = null
    var indicator: SlidingIconTabLayout? = null
    var titleList: ArrayList<String> = ArrayList()
    lateinit var homeAdapter: HomeAdapter

    override fun initListeren() {
        isPrepared = true
    }

    override fun initData() {

//        if (!isPrepared || !isVisible || mHasLoadedOnce) {
//            return
//        }

        var getHomeCateListPresenter = GetHomeCateListPresenter()
        getHomeCateListPresenter.addListener(this)
        getHomeCateListPresenter.loadDate()

        list!!.clear()
        list!!.add(Home1Fragment())
        list!!.add(Home2Fragment())
        list!!.add(Home3Fragment())
        list!!.add(Home4Fragment())
        list!!.add(Home5Fragment())

        mHasLoadedOnce = true
    }

    override fun otherClick(v: View?) {
    }

    override fun showHomeCateListSuccess(homeCateList: HomeCateList) {

        titleList.clear()

        for (it in homeCateList.data) {
            titleList.add(it.title)
        }

        titleList.add(0, "推荐")

        homeAdapter.notifyDataSetChanged()
        indicator!!.setViewPager(vp)
    }

    override fun showHomeCateListError(t: Throwable) {
        list.clear()
    }


    override fun createView(): View {
        return UI {
            verticalLayout {
                indicator = slidingIconTabLayout {
                    setCustomTabView(R.layout.tab_txt_layout, R.id.tab_name_txt)
                    setCustomTabColorizer(SlidingIconTabLayout.TabColorizer { return@TabColorizer resources.getColor(R.color.title_color) })
                }.lparams(height = 120, width = matchParent)
                vp = viewPager {
                    id = ViewID.VIEW_PAGER
                    homeAdapter = HomeAdapter(childFragmentManager, list, titleList)
                    adapter = homeAdapter
                }.lparams(width = matchParent, height = matchParent)
            }

        }.view
    }
}