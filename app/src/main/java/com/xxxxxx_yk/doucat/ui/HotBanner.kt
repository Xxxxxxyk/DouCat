package com.xxxxxx_yk.doucat.ui

import android.content.Context
import android.view.View
import com.xxxxxx_yk.doucat.ui.ViewToKotlin.banner
import com.xxxxxx_yk.doucat.utils.ViewID
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import org.jetbrains.anko.dip
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.relativeLayout

/**
 * Created by 惜梦哥哥 on 2018/1/26.
 */
object HotBanner {
    private lateinit var banner: Banner
    fun getHotBanner(cts: Context): Banner {
        with(cts) {
            relativeLayout {
                banner = banner {
                    id = ViewID.BANNER
                    setBannerStyle(BannerConfig.NUM_INDICATOR)
                    isAutoPlay(true)
                }.lparams(width = matchParent, height = dip(150))
            }
        }
        return banner
    }
}