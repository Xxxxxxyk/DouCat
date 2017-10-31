package com.xxxxxx_yk.doucat.views.impl

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.kimkevin.slidingicontablayout.wigets.SlidingIconTabLayout
import com.xxxxxx_yk.doucat.R
import com.xxxxxx_yk.doucat.ui.ViewToKotlin.slidingIconTabLayout
import com.xxxxxx_yk.doucat.utils.Constant
import com.xxxxxx_yk.doucat.utils.ViewID
import com.xxxxxx_yk.doucat.views.adapter.HomeAdapter
import com.xxxxxx_yk.doucat.views.impl.home.Home1Fragment
import com.xxxxxx_yk.doucat.views.impl.home.Home2Fragment
import com.xxxxxx_yk.doucat.views.impl.home.Home3Fragment
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.viewPager
import org.jetbrains.anko.verticalLayout
import org.jetbrains.anko.wrapContent

/**
 * Created by 华农天时-Qiuzi on 2017/9/25.
 */
class HomeFragment : Fragment() {

    var list: ArrayList<Fragment>? = null
    var vp: ViewPager? = null
    var indicator: SlidingIconTabLayout? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        list = ArrayList<Fragment>()
        list!!.add(Home1Fragment())
        list!!.add(Home2Fragment())
        list!!.add(Home3Fragment())
        return createView()
    }

    fun createView(): View {
        return UI {
            verticalLayout {
                indicator = slidingIconTabLayout {
                    setCustomTabView(R.layout.tab_txt_layout, R.id.tab_name_txt)
                    setCustomTabColorizer(SlidingIconTabLayout.TabColorizer{ return@TabColorizer resources.getColor(R.color.title_color) })
                }.lparams(height = 120, width = matchParent)
                vp = viewPager {
                    id = ViewID.VIEW_PAGER
                    adapter = HomeAdapter(fragmentManager, list!!, Constant.TITLE)
                }.lparams(width = matchParent, height = matchParent)
            }
            indicator!!.setViewPager(vp)
        }.view
    }
}