package com.xxxxxx_yk.doucat.views.adapter

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.xxxxxx_yk.doucat.R
import com.xxxxxx_yk.doucat.application.GlideApp
import com.xxxxxx_yk.doucat.model.VerticalData

class FaceAdapter(var context : Context , var list_face : List<VerticalData>) : RecyclerView.Adapter<FaceAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_face, null))
    }

    override fun getItemCount(): Int {
        if(list_face == null){
            return 0
        }else{
            return 4
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        GlideApp.with(context)
                .load(list_face.get(position).verticalSrc)
                .placeholder(R.mipmap.image_banner_loading)
                .fitCenter()
                .into(holder.iv_face_src);
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var iv_face_src = itemView!!.findViewById<ImageView>(R.id.iv_face_src)
    }
}