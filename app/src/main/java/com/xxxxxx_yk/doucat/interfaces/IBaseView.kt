package com.xxxxxx_yk.doucat.interfaces

import android.view.View

/**
 * Created by 华农天时-Qiuzi on 2017/9/20.
 */
interface IBaseView {
    /**
     * 书写布局
     */
    fun initView()

    /**
     * 监听器
     */
    fun initListeren()

    /**
     * 初始化数据
     */
    fun initData()

    /**
     * 点击事件
     */
    fun otherClick(v : View?)

}