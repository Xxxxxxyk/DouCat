package com.xxxxxx_yk.doucat.views.impl.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.textView

/**
 * Created by 华农天时-Qiuzi on 2017/10/16.
 */
class Home5Fragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return UI {
            relativeLayout {
                textView {
                    text = "5555555555555555555555"
                }
            }
        }.view
    }
}