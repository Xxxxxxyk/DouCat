package com.xxxxxx_yk.doucat.views.home

import android.os.Handler
import android.view.View
import com.blankj.utilcode.util.SPUtils
import com.xxxxxx_yk.doucat.R
import com.xxxxxx_yk.doucat.utils.Constant
import com.xxxxxx_yk.doucat.views.BaseActivity
import org.jetbrains.anko.backgroundResource
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.verticalLayout

/**
 * Created by 惜梦哥哥_ on 2017/9/20.
 */

class SplashActivity : BaseActivity() {

    var spUtils = SPUtils.getInstance()

    override fun initView() {
        verticalLayout {
            backgroundResource = R.mipmap.bg_splash
        }
    }

    override fun initListeren() {

    }

    override fun initData() {
        Handler().postDelayed({
            if (spUtils.getBoolean(Constant.IS_AGAIN_COME)) {
                startActivity<MainActivity>()
            } else {
                spUtils.put(Constant.IS_AGAIN_COME, true)
                startActivity<WelcomeActivity>()
            }
            finish()
        }, 5000)
    }


    override fun otherClick(v: View?) {
    }

}