package com.xxxxxx_yk.doucat.views.home

import android.graphics.Color
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.Button
import com.xxxxxx_yk.doucat.views.BaseActivity
import com.xxxxxx_yk.doucat.R
import com.xxxxxx_yk.doucat.views.adapter.WelcomeAdapter
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.support.v4.viewPager

/**
 * Created by 华农天时-Qiuzi on 2017/9/20.
 */
class WelcomeActivity : BaseActivity() {

    val WELCOME_RES: IntArray = intArrayOf(R.mipmap.guide_bg1, R.mipmap.guide_bg2, R.mipmap.guide_bg3, R.mipmap.guide_bg4)
    var btn_open: Button? = null
    var vp_guide: ViewPager? = null

    override fun initView() {
        relativeLayout {
            padding = dip(5)
            vp_guide = viewPager {
                adapter = WelcomeAdapter(this@WelcomeActivity, WELCOME_RES)

            }.lparams(width = matchParent , height = matchParent)

            btn_open = button {
                text = "开启全新体验"
                backgroundResource = R.drawable.blue_btn_selector
                textSize = px2sp(50)
                textColor = Color.WHITE
                visibility = View.GONE
                onClick {
                    startActivity<MainActivity>()
                    finish()
                }
            }.lparams(width = 500 , height = 150) {
                alignParentBottom()
                bottomMargin = 100
                centerHorizontally()
            }
        }
    }

    override fun initListeren() {
        vp_guide!!.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                if (position == WELCOME_RES.size - 1) {
                    btn_open!!.visibility = View.VISIBLE
                } else {
                    btn_open!!.visibility = View.GONE
                }
            }

        })
    }


    override fun initData() {

    }

    override fun otherClick(v: View?) {
    }
}