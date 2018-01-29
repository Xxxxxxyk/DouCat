package com.xxxxxx_yk.doucat.views.impl

import android.view.View
import com.xxxxxx_yk.doucat.views.BaseFragment
import org.jetbrains.anko.centerInParent
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.textView


/**
 * Created by 惜梦哥哥_ on 2017/9/25.
 */
class LiveFragment : BaseFragment() {

    var isPrepared: Boolean = false
    var mHasLoadedOnce: Boolean = false

    override fun initListerenAndAdapter() {
    }

    override fun initData() {
        if (!isPrepared || !isVisible || mHasLoadedOnce) {
            return
        }
        mHasLoadedOnce = true
    }

    override fun otherClick(v: View?) {
    }

    override fun createView(): View {
        return UI {
            relativeLayout() {
                textView {
                    text = "直播"
                    textSize = 40F
                }.lparams{
                    centerInParent()
                }
            }
        }.view
    }
}