package com.xxxxxx_yk.doucat.views.home

import android.os.Build
import android.support.annotation.RequiresApi
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentTransaction
import android.view.MenuItem
import android.view.View
import com.xxxxxx_yk.doucat.BaseActivity
import com.xxxxxx_yk.doucat.R
import com.xxxxxx_yk.doucat.ui.ViewToKotlin.bottomNavigationView
import com.xxxxxx_yk.doucat.utils.ViewID
import com.xxxxxx_yk.doucat.views.impl.*
import org.jetbrains.anko.*


class MainActivity : BaseActivity() {

    var bnv_btn: BottomNavigationView? = null
    var fragmentTransaction: FragmentTransaction? = null
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
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            when (item.itemId) {
                R.id.dc_home -> {
                    fragmentTransaction!!.show(home_fragment).hide(live_fragment).hide(video_fragment).hide(follow_fragment).hide(user_fragment).commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.dc_live -> {
                    fragmentTransaction!!.show(live_fragment).hide(home_fragment).hide(video_fragment).hide(follow_fragment).hide(user_fragment).commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.dc_video -> {
                    fragmentTransaction!!.show(video_fragment).hide(live_fragment).hide(home_fragment).hide(follow_fragment).hide(user_fragment).commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.dc_follow -> {
                    fragmentTransaction!!.show(follow_fragment).hide(live_fragment).hide(video_fragment).hide(home_fragment).hide(user_fragment).commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.dc_user -> {
                    fragmentTransaction!!.show(user_fragment).hide(live_fragment).hide(video_fragment).hide(follow_fragment).hide(home_fragment).commit()
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false
        }
    }

    override fun initData() {
        fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction!!.add(ViewID.FL_FRAGMENT, home_fragment)
        fragmentTransaction!!.add(ViewID.FL_FRAGMENT, live_fragment)
        fragmentTransaction!!.add(ViewID.FL_FRAGMENT, video_fragment)
        fragmentTransaction!!.add(ViewID.FL_FRAGMENT, follow_fragment)
        fragmentTransaction!!.add(ViewID.FL_FRAGMENT, user_fragment)
        fragmentTransaction!!.show(home_fragment).hide(live_fragment).hide(video_fragment).hide(follow_fragment).hide(user_fragment).commit()
    }

    override fun otherClick(v: View?) {

    }

}
