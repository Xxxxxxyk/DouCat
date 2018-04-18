package com.xxxxxx_yk.doucat.views.adapter

import android.content.Context
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
import org.jetbrains.anko.imageResource

class MainTitleAdapter(var home_title: String, var context: Context, var layoutHelper: LayoutHelper, var count: Int, var layoutParams: ViewGroup.LayoutParams) : DelegateAdapter.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MainTitleViewHolder(LayoutInflater.from(context).inflate(R.layout.item_main_title, parent, false))
    }

    override fun getItemCount(): Int {
        return count
    }

    override fun onCreateLayoutHelper(): LayoutHelper {
        return layoutHelper
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder!!.itemView.layoutParams = VirtualLayoutManager.LayoutParams(layoutParams)
    }

    override fun onBindViewHolderWithOffset(holder: RecyclerView.ViewHolder?, position: Int, offsetTotal: Int) {
        val mainTitleViewHolder = holder as MainTitleViewHolder
        mainTitleViewHolder.homeTitle.text = home_title
        when(home_title){
            "最热" -> mainTitleViewHolder.iv_title_src.imageResource = R.mipmap.reco_game_txt_icon
            "颜值" -> mainTitleViewHolder.iv_title_src.imageResource = R.mipmap.icon_reco_mobile
            else -> mainTitleViewHolder.iv_title_src.imageResource = R.mipmap.icon_column
        }
    }

    class MainTitleViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var homeTitle = itemView!!.findViewById<TextView>(R.id.tv_home_title)
        var iv_title_src = itemView!!.findViewById<ImageView>(R.id.iv_title_src)
    }
}