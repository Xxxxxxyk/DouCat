package com.xxxxxx_yk.doucat

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.xxxxxx_yk.doucat.interfaces.IBaseView

/**
 * Created by 惜梦哥哥_ on 2017/9/20.
 */
abstract class BaseActivity : AppCompatActivity(),View.OnClickListener, IBaseView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initListerenAndAdapter()
        initData()
    }


    override fun onClick(view: View?) {
        when(view?.id){
            R.id.back -> { finish() }
            else -> { otherClick(view)}
        }
    }
}
