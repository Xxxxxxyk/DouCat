package com.xxxxxx_yk.doucat.views.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.bumptech.glide.Glide
import com.xxxxxx_yk.doucat.R
import com.xxxxxx_yk.doucat.application.GlideApp
import com.xxxxxx_yk.doucat.interfaces.OnItemClickListener
import com.xxxxxx_yk.doucat.model.Hot_Data
import com.xxxxxx_yk.doucat.utils.Constant
import com.xxxxxx_yk.doucat.views.video.VideoPlayerActivity
import org.jetbrains.anko.support.v4.dip
import org.w3c.dom.Text

/**
 * Created by 惜梦哥哥 on 2018/3/30.
 */
class BestHomeHotAdapter(var context: Context, var list: List<Hot_Data>, var layoutHelper: LayoutHelper, var count: Int) : DelegateAdapter.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateLayoutHelper(): LayoutHelper {
        return layoutHelper
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_best_hot, null))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder!!.itemView.layoutParams = VirtualLayoutManager.LayoutParams(VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 320))
    }

    override fun onBindViewHolderWithOffset(holder: RecyclerView.ViewHolder?, position: Int, offsetTotal: Int) {
        var myHolder = holder as ViewHolder
        GlideApp.with(context)
                .load(list.get(position).verticalSrc)
                .placeholder(R.mipmap.image_banner_loading)
                .fitCenter()
                .into(myHolder.iv_live_src);
        myHolder.tv_roomname.text = list.get(position).roomName
        myHolder.tv_online_number.text = list.get(position).online
        myHolder.tv_nickname.text = list.get(position).nickname

        myHolder.itemView.setOnClickListener({
            var intent = Intent(context, VideoPlayerActivity::class.java)
            intent.putExtra(Constant.ROOM_ID, list.get(position).roomId)
            context.startActivity(intent)
        })

    }

    override fun getItemCount(): Int {
        return count
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var iv_live_src = itemView!!.findViewById<ImageView>(R.id.iv_live_src)
        var tv_roomname = itemView!!.findViewById<TextView>(R.id.tv_roomname)
        var tv_online_number = itemView!!.findViewById<TextView>(R.id.tv_online_number)
        var tv_nickname = itemView!!.findViewById<TextView>(R.id.tv_nickname)
    }
}