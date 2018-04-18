package com.xxxxxx_yk.doucat.views.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.xxxxxx_yk.doucat.R
import com.xxxxxx_yk.doucat.model.HomeBanners
import com.xxxxxx_yk.doucat.utils.Constant
import com.xxxxxx_yk.doucat.utils.GlideImageLoader
import com.xxxxxx_yk.doucat.views.video.VideoPlayerActivity
import com.youth.banner.Banner
import com.youth.banner.BannerConfig

class MainBannerAdapter(var home_data: HomeBanners, var context: Context, var layoutHelper: LayoutHelper, var count: Int) : DelegateAdapter.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BannerViewHolder(LayoutInflater.from(context).inflate(R.layout.item_main_banner, parent, false))
    }

    override fun getItemCount(): Int {
        return count
    }

    override fun onCreateLayoutHelper(): LayoutHelper {
        return layoutHelper
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val banner = (holder as BannerViewHolder).banner
        var list = ArrayList<String>()
        for (banner in home_data.data) {
            list.add(banner.picUrl)
        }

        banner.setImages(list).setBannerStyle(BannerConfig.NUM_INDICATOR).setImageLoader(GlideImageLoader()).isAutoPlay(true).setOnBannerListener {
            var intent = Intent(context, VideoPlayerActivity::class.java)
            intent.putExtra(Constant.ROOM_ID, home_data.data.get(position).room.roomId)
            context.startActivity(intent)
        }.start()
    }


    class BannerViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var banner = itemView!!.findViewById<Banner>(R.id.banner)
    }
}