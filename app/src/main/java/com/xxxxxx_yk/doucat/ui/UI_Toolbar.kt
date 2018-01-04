package com.xxxxxx_yk.doucat.ui

import android.app.Activity
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.Toolbar
import com.xxxxxx_yk.doucat.R
import com.xxxxxx_yk.doucat.utils.ViewID
import org.jetbrains.anko.*

/**
 * Created by 华农天时-Qiuzi on 2017/10/16.
 */
//用internal object 标识,即可在全局中引用布局
internal object UI_Toolbar {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun _RelativeLayout.dcToolbar(): Toolbar {
        return toolbar {
            id = ViewID.TOOL_BAR
            title = ""
            backgroundResource = R.color.colorPrimary
            relativeLayout {
                imageView ( R.mipmap.logo_icon).lparams(width = 200 , height = 120)
                linearLayout {
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_VERTICAL
                    imageView (R.drawable.img_message){ isClickable = true }.lparams(width = 60, height = 60) { rightMargin = 35 }
                    imageView (R.drawable.img_history) { isClickable = true }.lparams(width = 60, height = 60) { rightMargin = 35 }
                    imageView (R.drawable.img_scanner){ isClickable = true }.lparams(width = 60, height = 60) { rightMargin = 35 }
                    imageView (R.drawable.img_search){ isClickable = true }.lparams(width = 60, height = 60) { rightMargin = 35 }
                }.lparams(height = wrapContent , width = wrapContent) {
                    alignParentRight()
                    centerVertically()
                }
            }
        }
    }
}