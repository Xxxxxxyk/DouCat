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
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.UI


/**
 * Created by 华农天时-Qiuzi on 2017/9/25.
 */
class UserFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return createView()
    }

    fun createView(): View {
        return UI {
            verticalLayout() {
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
                    linearLayout() {
                        verticalLayout(){
                            imageView(R.mipmap.new_history_image).lparams(width = 66, height = 66)
                            textView(){text = "观看历史"}
                        }.lparams(weight = 1f ,height = matchParent){
                            gravity = Gravity.CENTER
                        }

                        verticalLayout(){
                            imageView(R.mipmap.more_message).lparams(width = 66, height = 66)
                            textView(){text = "站内信"}
                        }.lparams(weight = 1f ,height = matchParent)

                        verticalLayout(){
                            imageView(R.mipmap.new_task_image).lparams(width = 66, height = 66)
                            textView(){text = "我的任务"}
                        }.lparams(weight = 1f ,height = matchParent)

                        verticalLayout(){
                            imageView(R.mipmap.recharge_image).lparams(width = 66, height = 66)
                            textView(){text = "鱼翅充值"}
                        }.lparams(weight = 1f ,height = matchParent)
//                        view(){backgroundColor = Color.BLACK}.lparams(height = 120,weight = 1f)

//                        view(){backgroundColor = Color.BLACK}.lparams(height = 120,weight = 1f)

//                        view(){backgroundColor = Color.BLACK}.lparams(height = 120,weight = 1f)

                    }.lparams(width = matchParent, height = 200){

                    }
                }
            }
        }.view
    }
}