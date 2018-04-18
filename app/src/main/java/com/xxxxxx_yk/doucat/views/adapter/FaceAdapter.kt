package com.xxxxxx_yk.doucat.views.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.xxxxxx_yk.doucat.R
import com.xxxxxx_yk.doucat.application.GlideApp
import com.xxxxxx_yk.doucat.interfaces.OnItemClickListener
import com.xxxxxx_yk.doucat.model.VerticalData
import com.xxxxxx_yk.doucat.utils.Constant
import com.xxxxxx_yk.doucat.views.video.VideoPlayerActivity

class FaceAdapter(private var context : Context ,private var list_face : List<VerticalData>, private var layoutHelper: LayoutHelper,private var count: Int) : DelegateAdapter.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateLayoutHelper(): LayoutHelper {
        return layoutHelper
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_face, null))
    }

    override fun getItemCount(): Int {
        return count
    }

    override fun onBindViewHolder(holder:  RecyclerView.ViewHolder, position: Int) {
        holder!!.itemView.layoutParams = VirtualLayoutManager.LayoutParams(VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 770))
    }

    override fun onBindViewHolderWithOffset(holder: RecyclerView.ViewHolder?, position: Int, offsetTotal: Int) {
        val viewHolder = holder as ViewHolder
        GlideApp.with(context)
                .load(list_face.get(position).verticalSrc)
                .placeholder(R.mipmap.image_banner_loading)
                .fitCenter()
                .into(viewHolder.iv_face_src);
        viewHolder.tv_online_number.text = list_face.get(position).online
        viewHolder.tv_nickname.text = list_face.get(position).nickname
        viewHolder.tv_location.text = list_face.get(position).anchorCity

            viewHolder.itemView.setOnClickListener({
                var intent = Intent(context, VideoPlayerActivity::class.java)
                intent.putExtra(Constant.ROOM_ID, list_face.get(position).roomId)
                context.startActivity(intent)
            })
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var iv_face_src = itemView!!.findViewById<ImageView>(R.id.iv_face_src)
        var tv_online_number = itemView!!.findViewById<TextView>(R.id.tv_online_number)
        var tv_nickname = itemView!!.findViewById<TextView>(R.id.tv_nickname)
        var tv_location = itemView!!.findViewById<TextView>(R.id.tv_location)
    }

}