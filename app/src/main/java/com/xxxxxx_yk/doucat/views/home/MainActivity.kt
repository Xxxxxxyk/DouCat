package com.xxxxxx_yk.doucat.views.home

import android.os.Build
import android.support.annotation.RequiresApi
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import android.view.View
import com.blankj.utilcode.util.FragmentUtils
import com.blankj.utilcode.util.LogUtils
import com.xxxxxx_yk.doucat.R
import com.xxxxxx_yk.doucat.interfaces.GetHomeCateListListener
import com.xxxxxx_yk.doucat.model.HomeCateList
import com.xxxxxx_yk.doucat.utils.ViewID
import com.xxxxxx_yk.doucat.views.BaseActivity
import com.xxxxxx_yk.doucat.views.impl.*
import org.jetbrains.anko.*
import org.jetbrains.anko.design.bottomNavigationView


class MainActivity : BaseActivity() , GetHomeCateListListener {

    private var bnv_btn: BottomNavigationView? = null
    private var home_fragment : HomeFragment = HomeFragment()
    private var live_fragment : LiveFragment = LiveFragment()
    private var video_fragment : VideoFragment = VideoFragment()
    private var follow_fragment : FollowFragment = FollowFragment()
    private var user_fragment : UserFragment = UserFragment()
    private lateinit var current_fragment : Fragment


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


    override fun initListerenAndAdapter() {
        bnv_btn!!.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.dc_home -> {
                    switchFragment(home_fragment)
//                    FragmentUtils.replace(supportFragmentManager,home_fragment,ViewID.FL_FRAGMENT,false)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.dc_live -> {
                    switchFragment(live_fragment)
//                    FragmentUtils.replace(supportFragmentManager,live_fragment,ViewID.FL_FRAGMENT,false)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.dc_video -> {
                    switchFragment(video_fragment)
//                    FragmentUtils.replace(supportFragmentManager,video_fragment,ViewID.FL_FRAGMENT,false)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.dc_follow -> {
                    switchFragment(follow_fragment)
//                    FragmentUtils.replace(supportFragmentManager,follow_fragment,ViewID.FL_FRAGMENT,false)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.dc_user -> {
                    switchFragment(user_fragment)
//                    FragmentUtils.replace(supportFragmentManager,user_fragment,ViewID.FL_FRAGMENT,false)
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false
        }
    }

    override fun initData() {
        FragmentUtils.add(supportFragmentManager,home_fragment,ViewID.FL_FRAGMENT)
        current_fragment = home_fragment
    }

    override fun otherClick(v: View?) {

    }

    override fun showHomeCateListSuccess(homeCateList: HomeCateList) {
        LogUtils.e(homeCateList)
    }

    override fun showHomeCateListError(t: Throwable) {
        t.printStackTrace()
    }

    fun switchFragment(fragment: Fragment){
        if(!fragment.isAdded){
            FragmentUtils.hide(current_fragment)
            FragmentUtils.add(supportFragmentManager,fragment,ViewID.FL_FRAGMENT,false)
        }else{
            FragmentUtils.hide(current_fragment)
            FragmentUtils.show(fragment)
        }
        current_fragment = fragment
    }
}
