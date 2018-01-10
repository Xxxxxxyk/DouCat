package com.xxxxxx_yk.doucat.views.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.ViewGroup
import com.blankj.utilcode.util.LogUtils

/**
 * Created by 惜梦哥哥_ on 2017/10/16.
 */
class HomeAdapter(fm : FragmentManager? ,var list : List<Fragment> , var title : List<String>) : FragmentPagerAdapter(fm){

    override fun getItem(position: Int): Fragment {
        return list[position]
    }

    override fun getCount(): Int {
        return  list.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return title[position]
    }


}