package com.xxxxxx_yk.doucat.ui

import android.content.Context
import android.view.View
import com.xxxxxx_yk.doucat.ui.ViewToKotlin.banner
import com.xxxxxx_yk.doucat.utils.GlideImageLoader
import com.xxxxxx_yk.doucat.utils.ViewID
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import org.jetbrains.anko.dip
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.relativeLayout

/**
 * Created by 惜梦哥哥 on 2018/1/26.
 */
class HotBanner(list : List<*>) {

    private lateinit var banner: Banner
    private var list = list

    fun getHotBanner(cts: Context): View {
        return with(cts) {
            relativeLayout {
                banner = banner {
                    id = ViewID.BANNER
                    setImages(list)
                    setBannerStyle(BannerConfig.NUM_INDICATOR)
                    setImageLoader(GlideImageLoader())
                    isAutoPlay(true)
                }.lparams(width = matchParent, height = dip(150))
            }
        }
    }

    fun start(){
        banner.start()
    }

    fun setOnBannerListener(onBannerListener : (it : Int) -> Unit){
        banner.setOnBannerListener{
            onBannerListener(it)
        }
    }
}