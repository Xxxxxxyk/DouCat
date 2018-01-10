package com.xxxxxx_yk.doucat.views.impl.home

import android.view.View
import com.xxxxxx_yk.doucat.views.BaseFragment
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.textView

/**
 * Created by 惜梦哥哥_ on 2017/10/16.
 */
class Home1Fragment : BaseFragment() {

    override fun initListeren() {
    }

    override fun initData() {

    }

    override fun otherClick(v: View?) {
    }

    override fun createView(): View {
        return UI {
            relativeLayout {
                textView {
                    text = "首页"
                }
            }
        }.view
    }
}