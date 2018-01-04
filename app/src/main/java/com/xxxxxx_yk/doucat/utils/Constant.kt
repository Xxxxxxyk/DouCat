package com.xxxxxx_yk.doucat.utils

/**
 * Created by 华农天时-Qiuzi on 2017/9/20.
 */
interface Constant {
    companion object {

        val BASE_URL = "http://www.douyu.com/"

        val IS_AGAIN_COME: String = "is_again_come"

        val TITLE : Array<String> = arrayOf("推荐","手游","娱乐")

        fun printHelloWorld(){
            print("helloword")
        }
    }
}