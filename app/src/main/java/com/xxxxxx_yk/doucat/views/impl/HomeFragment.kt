package com.xxxxxx_yk.doucat.views.impl

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.View
import com.github.kimkevin.slidingicontablayout.wigets.SlidingIconTabLayout
import com.xxxxxx_yk.doucat.R
import com.xxxxxx_yk.doucat.interfaces.GetHomeCateListListener
import com.xxxxxx_yk.doucat.model.HomeCateList
import com.xxxxxx_yk.doucat.presenter.GetHomeCateListPresenter
import com.xxxxxx_yk.doucat.ui.ViewToKotlin.slidingIconTabLayout
import com.xxxxxx_yk.doucat.utils.Constant
import com.xxxxxx_yk.doucat.utils.ViewID
import com.xxxxxx_yk.doucat.views.BaseFragment
import com.xxxxxx_yk.doucat.views.adapter.HomeAdapter
import com.xxxxxx_yk.doucat.views.impl.home.*
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.viewPager
import org.jetbrains.anko.verticalLayout

/**
 * Created by 惜梦哥哥_ on 2017/9/25.
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

        var getHomeCateListPresenter = GetHomeCateListPresenter(this)
        getHomeCateListPresenter.loadDate()
        list.clear()

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

        //TODO 不完美,应可以优化,时间不够,标记

        var home2 = Home2Fragment()
        var home2_bundle = Bundle()
        home2_bundle.putSerializable(Constant.HOME_CATE_LIST, homeCateList.data.get(0))
        home2.arguments = home2_bundle

        var home3 = Home3Fragment()
        var home3_bundle = Bundle()
        home3_bundle.putSerializable(Constant.HOME_CATE_LIST, homeCateList.data.get(1))
        home3.arguments = home3_bundle

        var home4 = Home4Fragment()
        var home4_bundle = Bundle()
        home4_bundle.putSerializable(Constant.HOME_CATE_LIST, homeCateList.data.get(2))
        home4.arguments = home4_bundle

        var home5 = Home5Fragment()
        var home5_bundle = Bundle()
        home5_bundle.putSerializable(Constant.HOME_CATE_LIST, homeCateList.data.get(3))
        home5.arguments = home5_bundle


        list.add(Home1Fragment())
        list.add(home2)
        list.add(home3)
        list.add(home4)
        list.add(home5)

        homeAdapter.notifyDataSetChanged()
        indicator!!.setViewPager(vp)
    }

    override fun showHomeCateListError(t: Throwable) {
        list.clear()
        t.printStackTrace()
    }

    override fun onDestroy() {
        super.onDestroy()
        homeAdapter.notifyDataSetChanged()
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