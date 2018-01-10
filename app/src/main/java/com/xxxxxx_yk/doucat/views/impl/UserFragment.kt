package com.xxxxxx_yk.doucat.views.impl

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xxxxxx_yk.doucat.R
import com.xxxxxx_yk.doucat.utils.ViewID
import com.xxxxxx_yk.doucat.views.BaseFragment
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.UI


/**
 * Created by 惜梦哥哥_ on 2017/9/25.
 */
class UserFragment : BaseFragment() {

    var isPrepared: Boolean = false
    var mHasLoadedOnce: Boolean = false

    override fun initListeren() {
    }

    override fun initData() {
        if (!isPrepared || !isVisible || mHasLoadedOnce) {
            return
        }

        mHasLoadedOnce = true
    }

    override fun otherClick(v: View?) {
    }


    override fun createView(): View {
        return UI {
            verticalLayout() {
                backgroundColor = Color.rgb(238, 238, 238)
                relativeLayout() {
                    backgroundResource = R.mipmap.usercenter_top_bg_day
                    button() {
                        id = ViewID.LOGIN_BUTTON
                        text = "登录"
                        textColor = Color.WHITE
                        backgroundResource = R.drawable.login_or_register
                    }.lparams(width = 230, height = 100) {
                        leftMargin = 100
                        centerVertically()
                    }
                    button() {
                        text = "注册"
                        textColor = Color.WHITE
                        backgroundResource = R.drawable.login_or_register
                    }.lparams(width = 230, height = 100) {
                        leftMargin = 70
                        rightOf(ViewID.LOGIN_BUTTON)
                        centerVertically()
                    }
                }.lparams(width = matchParent, height = 400)
                verticalLayout() {
                    backgroundColor = Color.WHITE
                    linearLayout() {
                        relativeLayout {
                            verticalLayout() {
                                imageView(R.mipmap.new_history_image).lparams(width = 66, height = 66) { gravity = Gravity.CENTER }
                                textView("观看历史").lparams(width = wrapContent) { topMargin = 10 }
                            }.lparams {
                                centerInParent()
                            }
                        }.lparams(weight = 1f, height = matchParent) {
                            gravity = Gravity.CENTER
                        }

                        linearLayout() { backgroundColor = Color.LTGRAY }.lparams(height = 100, weight = 0.03f) { gravity = Gravity.CENTER }

                        relativeLayout {
                            verticalLayout() {
                                imageView(R.mipmap.more_message).lparams(width = 66, height = 66) { gravity = Gravity.CENTER }
                                textView("站内信").lparams(width = wrapContent) { topMargin = 10 }
                            }.lparams {
                                centerInParent()
                            }
                        }.lparams(weight = 1f, height = matchParent) {
                            gravity = Gravity.CENTER
                        }

                        linearLayout() { backgroundColor = Color.LTGRAY }.lparams(height = 100, weight = 0.03f) { gravity = Gravity.CENTER }

                        relativeLayout {
                            verticalLayout() {
                                imageView(R.mipmap.new_task_image).lparams(width = 66, height = 66) { gravity = Gravity.CENTER }
                                textView("我的任务").lparams(width = wrapContent) { topMargin = 10 }
                            }.lparams {
                                centerInParent()
                            }
                        }.lparams(weight = 1f, height = matchParent) {
                            gravity = Gravity.CENTER
                        }

                        linearLayout() { backgroundColor = Color.LTGRAY }.lparams(height = 100, weight = 0.03f) { gravity = Gravity.CENTER }

                        relativeLayout {
                            verticalLayout() {
                                imageView(R.mipmap.recharge_image).lparams(width = 66, height = 66) { gravity = Gravity.CENTER }
                                textView("鱼翅充值").lparams(width = wrapContent) { topMargin = 10 }
                            }.lparams {
                                centerInParent()
                            }
                        }.lparams(weight = 1f, height = matchParent) {
                            gravity = Gravity.CENTER
                        }
                    }.lparams(width = matchParent, height = 200) {
                        gravity = Gravity.CENTER
                    }
                }

                linearLayout {
                    backgroundColor = Color.WHITE
                    imageView(R.mipmap.icon_anchor_recruit).lparams(width = wrapContent, height = wrapContent) {
                        gravity = Gravity.CENTER_VERTICAL
                        leftMargin = dip(5)
                    }

                    textView("主播招募") { textSize = 18f }.lparams(weight = 1f, height = wrapContent) {
                        gravity = Gravity.CENTER_VERTICAL
                        leftMargin = dip(15)
                    }

                    imageView(R.mipmap.usercenter_grey_arrow).lparams(width = wrapContent, height = wrapContent) {
                        gravity = Gravity.CENTER_VERTICAL
                        rightMargin = dip(5)
                    }
                }.lparams(width = matchParent, height = dip(50)) {
                    topMargin = dip(10)
                }

                linearLayout {
                    backgroundColor = Color.WHITE
                    imageView(R.mipmap.icon_my_video).lparams(width = wrapContent, height = wrapContent) {
                        gravity = Gravity.CENTER_VERTICAL
                        leftMargin = dip(5)
                    }

                    textView("我的视频") { textSize = 18f }.lparams(weight = 1f, height = wrapContent) {
                        gravity = Gravity.CENTER_VERTICAL
                        leftMargin = dip(15)
                    }

                    imageView(R.mipmap.usercenter_grey_arrow).lparams(width = wrapContent, height = wrapContent) {
                        gravity = Gravity.CENTER_VERTICAL
                        rightMargin = dip(5)
                    }
                }.lparams(width = matchParent, height = dip(50)) {
                    topMargin = dip(10)
                }

                linearLayout() { backgroundColor = Color.LTGRAY }.lparams(height = dip(1), width = matchParent)

                linearLayout {
                    backgroundColor = Color.WHITE
                    imageView(R.mipmap.icon_video_collection).lparams(width = wrapContent, height = wrapContent) {
                        gravity = Gravity.CENTER_VERTICAL
                        leftMargin = dip(5)
                    }

                    textView("视频收藏") { textSize = 18f }.lparams(weight = 1f, height = wrapContent) {
                        gravity = Gravity.CENTER_VERTICAL
                        leftMargin = dip(15)
                    }

                    imageView(R.mipmap.usercenter_grey_arrow).lparams(width = wrapContent, height = wrapContent) {
                        gravity = Gravity.CENTER_VERTICAL
                        rightMargin = dip(5)
                    }
                }.lparams(width = matchParent, height = dip(50))

                linearLayout {
                    backgroundColor = Color.WHITE
                    imageView(R.mipmap.icon_my_account).lparams(width = wrapContent, height = wrapContent) {
                        gravity = Gravity.CENTER_VERTICAL
                        leftMargin = dip(5)
                    }

                    textView("我的账户") { textSize = 18f }.lparams(weight = 1f, height = wrapContent) {
                        gravity = Gravity.CENTER_VERTICAL
                        leftMargin = dip(15)
                    }

                    imageView(R.mipmap.usercenter_grey_arrow).lparams(width = wrapContent, height = wrapContent) {
                        gravity = Gravity.CENTER_VERTICAL
                        rightMargin = dip(5)
                    }
                }.lparams(width = matchParent, height = dip(50)) {
                    topMargin = dip(10)
                }

                linearLayout() { backgroundColor = Color.LTGRAY }.lparams(height = dip(1), width = matchParent)

                linearLayout {
                    backgroundColor = Color.WHITE
                    imageView(R.mipmap.image_game).lparams(width = wrapContent, height = wrapContent) {
                        gravity = Gravity.CENTER_VERTICAL
                        leftMargin = dip(5)
                    }

                    textView("游戏中心") { textSize = 18f }.lparams(weight = 1f, height = wrapContent) {
                        gravity = Gravity.CENTER_VERTICAL
                        leftMargin = dip(15)
                    }

                    imageView(R.mipmap.usercenter_grey_arrow).lparams(width = wrapContent, height = wrapContent) {
                        gravity = Gravity.CENTER_VERTICAL
                        rightMargin = dip(5)
                    }
                }.lparams(width = matchParent, height = dip(50))

                linearLayout {
                    backgroundColor = Color.WHITE
                    imageView(R.mipmap.clock).lparams(width = wrapContent, height = wrapContent) {
                        gravity = Gravity.CENTER_VERTICAL
                        leftMargin = dip(5)
                    }

                    textView("开播提醒") { textSize = 18f }.lparams(weight = 1f, height = wrapContent) {
                        gravity = Gravity.CENTER_VERTICAL
                        leftMargin = dip(15)
                    }

                    imageView(R.mipmap.usercenter_grey_arrow).lparams(width = wrapContent, height = wrapContent) {
                        gravity = Gravity.CENTER_VERTICAL
                        rightMargin = dip(5)
                    }
                }.lparams(width = matchParent, height = dip(50)) {
                    topMargin = dip(10)
                }
            }
        }.view
    }
}