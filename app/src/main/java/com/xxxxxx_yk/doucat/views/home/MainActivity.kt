package com.xxxxxx_yk.doucat.views.home

import android.os.Build
import android.support.annotation.RequiresApi
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import android.view.View
import com.blankj.utilcode.util.FragmentUtils
import com.blankj.utilcode.util.LogUtils
import com.xxxxxx_yk.doucat.views.BaseActivity
import com.xxxxxx_yk.doucat.R
import com.xxxxxx_yk.doucat.interfaces.GetHomeCateListListener
import com.xxxxxx_yk.doucat.model.HomeCateList
import com.xxxxxx_yk.doucat.presenter.GetHomeCateListPresenter
import com.xxxxxx_yk.doucat.ui.ViewToKotlin.bottomNavigationView
import com.xxxxxx_yk.doucat.utils.ViewID
import com.xxxxxx_yk.doucat.views.impl.*
import org.jetbrains.anko.*


class MainActivity : BaseActivity() , GetHomeCateListListener {

    var bnv_btn: BottomNavigationView? = null
    var home_fragment : HomeFragment = HomeFragment()
    var live_fragment : LiveFragment = LiveFragment()
    var video_fragment : VideoFragment = VideoFragment()
    var follow_fragment : FollowFragment = FollowFragment()
    var user_fragment : UserFragment = UserFragment()


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun initView() {
        relativeLayout {
            frameLayout {
                id = ViewID.FL_FRAGMENT
            }.lparams(width = matchParent, height = matchParent) {
                below(ViewID.TOOL_BAR)
                above(ViewID.BNV_BOTTOM)
            }
            bnv_btn = bottomNavigationView {
                id = ViewID.BNV_BOTTOM
                backgroundColor = android.R.attr.windowBackground
                inflateMenu(R.menu.navigation)
            }.lparams(width = matchParent , height = wrapContent) {
                alignParentBottom()
            }
        }
    }


    override fun initListeren() {
        bnv_btn!!.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.dc_home -> {
                    FragmentUtils.replace(supportFragmentManager,home_fragment,ViewID.FL_FRAGMENT,true)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.dc_live -> {
                    FragmentUtils.replace(supportFragmentManager,live_fragment,ViewID.FL_FRAGMENT,true)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.dc_video -> {
                    FragmentUtils.replace(supportFragmentManager,video_fragment,ViewID.FL_FRAGMENT,true)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.dc_follow -> {
                    FragmentUtils.replace(supportFragmentManager,follow_fragment,ViewID.FL_FRAGMENT,true)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.dc_user -> {
                    FragmentUtils.replace(supportFragmentManager,user_fragment,ViewID.FL_FRAGMENT,true)
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false
        }
    }

    override fun initData() {
        FragmentUtils.add(supportFragmentManager,home_fragment,ViewID.FL_FRAGMENT)
    }

    override fun otherClick(v: View?) {

    }

    override fun showHomeCateListSuccess(homeCateList: HomeCateList) {
        LogUtils.e(homeCateList)
    }

    override fun showHomeCateListError(t: Throwable) {
        t.printStackTrace()
    }

}
