package com.xxxxxx_yk.doucat.views.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.xxxxxx_yk.doucat.R
import com.xxxxxx_yk.doucat.application.GlideApp
import com.xxxxxx_yk.doucat.model.Hot_Data
import org.w3c.dom.Text

/**
 * Created by 惜梦哥哥 on 2018/3/30.
 */
class BestHomeHotAdapter(var context: Context, var list: List<Hot_Data>) : RecyclerView.Adapter<BestHomeHotAdapter.ViewHolder>() {

    var mOnItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_best_hot,null))
    }

    override fun getItemCount(): Int {
        if (list == null) {
            return 0
        } else {
            return list.size
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        GlideApp.with(context)
                .load(list.get(position).verticalSrc)
                .placeholder(R.mipmap.image_banner_loading)
                .fitCenter()
                .into(holder.iv_live_src);
        holder.tv_roomname.text = list.get(position).roomName
        holder.tv_online_number.text = list.get(position).online
        holder.tv_nickname.text = list.get(position).nickname

        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener({
                mOnItemClickListener!!.onItemClick(holder.itemView, position)
            })
        }
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var iv_live_src = itemView!!.findViewById<ImageView>(R.id.iv_live_src)
        var tv_roomname = itemView!!.findViewById<TextView>(R.id.tv_roomname)
        var tv_online_number = itemView!!.findViewById<TextView>(R.id.tv_online_number)
        var tv_nickname = itemView!!.findViewById<TextView>(R.id.tv_nickname)
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        mOnItemClickListener = onItemClickListener
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }
}