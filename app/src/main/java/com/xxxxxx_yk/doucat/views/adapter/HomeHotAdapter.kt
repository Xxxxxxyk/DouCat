package com.xxxxxx_yk.doucat.views.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by 惜梦哥哥 on 2018/1/26.
 */
class HomeHotAdapter(resId: Int, list: List<String>) : BaseQuickAdapter<String, BaseViewHolder>(resId, list) {
    override fun convert(helper: BaseViewHolder?, item: String?) {
        helper!!.setText(android.R.id.text1, item)
    }
}