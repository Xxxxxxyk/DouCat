package com.xxxxxx_yk.doucat.ui;

import android.support.design.widget.BottomNavigationView
import android.view.ViewManager
import com.github.kimkevin.slidingicontablayout.wigets.SlidingIconTabLayout
import org.jetbrains.anko.custom.ankoView

/**
 * Created by 华农天时-Qiuzi on 2017/10/16.
 */

internal object ViewToKotlin {
    //让Anko支持BottomNavigationView
    inline fun ViewManager.bottomNavigationView(theme: Int = 0) = bottomNavigationView(theme) {}

    public inline fun ViewManager.bottomNavigationView(theme: Int = 0, init: BottomNavigationView.() -> Unit) = ankoView({ BottomNavigationView(it) }, theme, init)

    inline fun ViewManager.slidingIconTabLayout(theme: Int = 0) = slidingIconTabLayout(theme) {}

    public inline fun ViewManager.slidingIconTabLayout(theme: Int = 0, init: SlidingIconTabLayout.() -> Unit) = ankoView({ SlidingIconTabLayout(it) }, theme, init)

}
