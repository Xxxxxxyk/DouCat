package com.xxxxxx_yk.doucat.interfaces

import com.xxxxxx_yk.doucat.model.HomeCate

interface GetHomeCateListener {
    fun getHomeCateSuccess(homeCate: HomeCate)

    fun getHomeCateError(t: Throwable)
}