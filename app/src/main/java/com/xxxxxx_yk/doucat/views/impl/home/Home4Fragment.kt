package com.xxxxxx_yk.doucat.views.impl.home

import android.view.View
import android.widget.TextView
import com.xxxxxx_yk.doucat.interfaces.GetOtherHomeCateListener
import com.xxxxxx_yk.doucat.model.HomeCateListData
import com.xxxxxx_yk.doucat.model.HomeOtherCate
import com.xxxxxx_yk.doucat.presenter.GetOtherHomeCatePresenter
import com.xxxxxx_yk.doucat.utils.Constant
import com.xxxxxx_yk.doucat.views.BaseFragment
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.textView

/**
 * Created by 惜梦哥哥_ on 2017/10/16.
 */
class Home4Fragment : BaseFragment(), GetOtherHomeCateListener {


    private lateinit var mBundle: HomeCateListData
    private lateinit var mHomeOhterCate : HomeOtherCate
    private lateinit var tvNeirong : TextView

    override fun initListeren() {
    }

    override fun initData() {
        mBundle = arguments!!.getSerializable(Constant.HOME_CATE_LIST) as HomeCateListData
        var getOtherHomeCatePresenter = GetOtherHomeCatePresenter(this, mBundle.identification)
        getOtherHomeCatePresenter.loadDate()
    }

    override fun getOtherHomeCateSuccess(homeOtherCate: HomeOtherCate) {
        this.mHomeOhterCate = homeOtherCate
        tvNeirong.setText(mHomeOhterCate.data.get(0).toString())
    }

    override fun getOtherHomeCateError(t: Throwable) {
    }

    override fun otherClick(v: View?) {
    }

    override fun createView(): View {
        return UI {
            relativeLayout {
                tvNeirong = textView {
                    text = ""
                }
            }
        }.view
    }
}