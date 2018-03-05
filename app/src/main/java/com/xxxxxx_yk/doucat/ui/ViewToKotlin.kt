package com.xxxxxx_yk.doucat.ui;

import android.view.ViewManager
import com.github.kimkevin.slidingicontablayout.wigets.SlidingIconTabLayout
import com.youth.banner.Banner
import org.jetbrains.anko.custom.ankoView

/**
 * Created by 惜梦哥哥_ on 2017/10/16.
 */

internal object ViewToKotlin {
//    //让Anko支持BottomNavigationView,直接依赖Anko Design,省略
//    inline fun ViewManager.bottomNavigationView(theme: Int = 0) = bottomNavigationView(theme) {}
//
//    public inline fun ViewManager.bottomNavigationView(theme: Int = 0, init: BottomNavigationView.() -> Unit) = ankoView({ BottomNavigationView(it) }, theme, init)

    inline fun ViewManager.slidingIconTabLayout(theme: Int = 0) = slidingIconTabLayout(theme) {}
    public inline fun ViewManager.slidingIconTabLayout(theme: Int = 0, init: SlidingIconTabLayout.() -> Unit) = ankoView({ SlidingIconTabLayout(it) }, theme, init)

    inline fun ViewManager.banner(theme: Int = 0) = banner(theme) {}
    public inline fun ViewManager.banner(theme: Int = 0 , init : Banner.() -> Unit) = ankoView({Banner(it,null)}, theme , init)


    inline fun ViewManager.videoPlayerView(theme: Int = 0) = videoPlayerView(theme){}
    public inline fun ViewManager.videoPlayerView(theme: Int = 0 , init : VideoView.() -> Unit) = ankoView({VideoView(it)},theme, init)
}
