package com.xxxxxx_yk.doucat.views.impl

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xxxxxx_yk.doucat.views.BaseFragment
import org.jetbrains.anko.centerInParent
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.textView


/**
 * Created by 华农天时-Qiuzi on 2017/9/25.
 */
class VideoFragment : BaseFragment() {

    var isPrepared: Boolean = false
    var mHasLoadedOnce: Boolean = false

    override fun initListeren() {
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
                    text = "视频"
                    textSize = 40F
                }.lparams {
                    centerInParent()
                }
            }
        }.view
    }
}