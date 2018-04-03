package com.xxxxxx_yk.doucat.views.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.xxxxxx_yk.doucat.R
import com.xxxxxx_yk.doucat.application.GlideApp
import com.xxxxxx_yk.doucat.model.Hot_Data
import com.xxxxxx_yk.doucat.model.VerticalData
import com.xxxxxx_yk.doucat.model.VerticalRoom
import com.xxxxxx_yk.doucat.utils.Constant
import com.xxxxxx_yk.doucat.views.video.VideoPlayerActivity
import org.jetbrains.anko.imageResource

/**
 * Created by 惜梦哥哥 on 2018/1/26.
 */
class HomeHotAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list_hot: ArrayList<Hot_Data> = ArrayList()
    private var list_face: ArrayList<VerticalData> = ArrayList()
    private lateinit var mContext: Context
    private lateinit var bestHomeAdapter: BestHomeHotAdapter
    private lateinit var faceAdapter : FaceAdapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            0 -> return BestHotViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_hot, parent, false))
            1 -> return VerticalRoomViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_hot, parent, false))
            else -> return OtherViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home_hot, parent, false))
        }
    }

    override fun getItemCount(): Int {
        return 2
    }

    fun setContext(context: Context) {
        mContext = context
        bestHomeAdapter = BestHomeHotAdapter(mContext, list_hot)
        faceAdapter = FaceAdapter(mContext, list_face)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is BestHotViewHolder) {
            holder.homeTitle.text = "最热"
            holder.iv_title_src.imageResource = R.mipmap.reco_game_txt_icon
            holder.rv_list.layoutManager = GridLayoutManager(mContext, 2, GridLayoutManager.VERTICAL, false)
            holder.rv_list.adapter = bestHomeAdapter

            bestHomeAdapter.setOnItemClickListener(object : BestHomeHotAdapter.OnItemClickListener {
                override fun onItemClick(view: View, position: Int) {
                    var intent = Intent(mContext, VideoPlayerActivity::class.java)
                    intent.putExtra(Constant.ROOM_ID, list_hot.get(position).roomId)
                    mContext.startActivity(intent)
                }
            })
        } else if (holder is VerticalRoomViewHolder) {
            holder.homeTitle.text = "颜值"
            holder.iv_title_src.imageResource = R.mipmap.icon_reco_mobile
            holder.rv_list.layoutManager = GridLayoutManager(mContext, 2, GridLayoutManager.VERTICAL, false)
            holder.rv_list.adapter = faceAdapter
        } else {

        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            0
        } else if (position == 1) {
            1
        } else
            2
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        val manager = recyclerView.layoutManager
        if (manager is GridLayoutManager) {
            val gridManager = manager
            gridManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    val type = getItemViewType(position)
                    when (type) {
                        0, 1, 2 -> return gridManager.spanCount
                        else -> return 1
                    }
                }
            }
        }
    }

    /**
     * 以下方法为获取数据
     */
    fun getHotData(hot_data: List<Hot_Data>) {
        list_hot.clear()
        list_hot.addAll(hot_data)
        bestHomeAdapter.notifyDataSetChanged()
    }

    fun getFaceData(hot_data: List<VerticalData>) {
        list_face.clear()
        list_face.addAll(hot_data)
        bestHomeAdapter.notifyDataSetChanged()
    }


    class BestHotViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var homeTitle = itemView!!.findViewById<TextView>(R.id.tv_home_title)
        var iv_title_src = itemView!!.findViewById<ImageView>(R.id.iv_title_src)
        var rv_list = itemView!!.findViewById<RecyclerView>(R.id.rv_list)
    }

    class VerticalRoomViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var homeTitle = itemView!!.findViewById<TextView>(R.id.tv_home_title)
        var iv_title_src = itemView!!.findViewById<ImageView>(R.id.iv_title_src)
        var rv_list = itemView!!.findViewById<RecyclerView>(R.id.rv_list)
    }

    class OtherViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    }
}