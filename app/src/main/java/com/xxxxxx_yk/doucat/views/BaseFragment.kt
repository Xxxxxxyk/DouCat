package com.xxxxxx_yk.doucat.views

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.blankj.utilcode.util.FragmentUtils
import com.xxxxxx_yk.doucat.R
import com.xxxxxx_yk.doucat.interfaces.IBaseView

/**
 * Created by 惜梦哥哥 on 2018/1/4.
 */
abstract class BaseFragment : Fragment(), IBaseView, View.OnClickListener {

    private var isCanSee: Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view  = createView()
        initListerenAndAdapter()
        lazyLoad()
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun initView() {

    }

    abstract fun createView(): View

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.back -> {
                FragmentUtils.remove(this)
            }
            else -> {
                otherClick(view)
            }
        }
    }

    //懒加载
    fun lazyLoad() {
        initData()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)

        if (userVisibleHint) {
            isCanSee = true
            onVisible()

        } else {
            isCanSee = false
            onInvisible()
        }
    }

    /**
     * 可见
     */
    protected fun onVisible() {
//        lazyLoad();
    }


    /**
     * 不可见
     */
    protected fun onInvisible() {

    }
}