package com.xxxxxx_yk.doucat.presenter

import com.xxxxxx_yk.doucat.interfaces.*
import com.xxxxxx_yk.doucat.model.LiveVideoUrl
import com.xxxxxx_yk.doucat.model.VerticalRoom
import com.xxxxxx_yk.doucat.services.RetrofitSingleton
import com.xxxxxx_yk.doucat.utils.BaseParams
import com.xxxxxx_yk.doucat.utils.Constant
import com.xxxxxx_yk.doucat.utils.ParamsUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

/**
 * Created by 惜梦哥哥 on 2018/3/6.
 */
class GetVerticalRoomPresenter(listener: GetVerticalRoomListener) : BasePresenter {

    private var listen = listener

    override fun loadDate() {
        RetrofitSingleton.get()
                .initServices()
                .create(APIDoc::class.java)
                .getVerticalRoom(BaseParams.getBaseParams())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer<VerticalRoom> { verticalRoom -> listen.getVerticalRoomSuccess(verticalRoom) }, Consumer<Throwable> { t -> listen.getVerticalRoomError(t) })
    }
}