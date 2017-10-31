package com.xxxxxx_yk.doucat.views.home

import android.os.Handler
import android.view.View
import com.vondear.rxtools.RxSPUtils
import com.xxxxxx_yk.doucat.BaseActivity
import com.xxxxxx_yk.doucat.R
import com.xxxxxx_yk.doucat.utils.Constant
import org.jetbrains.anko.*

/**
 * Created by 华农天时-Qiuzi on 2017/9/20.
 */

class SplashActivity : BaseActivity() {

    override fun initView() {
        verticalLayout {
            backgroundResource = R.mipmap.bg_splash
        }
    }

    override fun initListeren() {

    }

    override fun initData() {
        Handler().postDelayed({
            if (RxSPUtils.getBoolean(this, Constant.IS_AGAIN_COME)) {
                startActivity<MainActivity>()
            } else {
                RxSPUtils.putBoolean(this, Constant.IS_AGAIN_COME, true)
                startActivity<WelcomeActivity>()
            }
            finish()
        }, 5000)
    }

    override fun otherClick(v: View?) {
    }

}