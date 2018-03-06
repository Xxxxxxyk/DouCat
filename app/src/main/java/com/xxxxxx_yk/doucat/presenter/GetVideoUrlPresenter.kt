package com.xxxxxx_yk.doucat.presenter

import com.xxxxxx_yk.doucat.interfaces.APIDoc
import com.xxxxxx_yk.doucat.interfaces.BasePresenter
import com.xxxxxx_yk.doucat.interfaces.GetOtherHomeCateListener
import com.xxxxxx_yk.doucat.interfaces.GetVideoUrlListener
import com.xxxxxx_yk.doucat.model.LiveVideoUrl
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
class GetVideoUrlPresenter(private var room_id : String ,listener: GetVideoUrlListener) : BasePresenter {

    private var listen = listener

    override fun loadDate() {
        RetrofitSingleton.get()
                .setBaseUrl(Constant.VIDEO_URL)
                .initServices()
                .create(APIDoc::class.java)
                .getVideoUrl(ParamsUtils.getVideoUrl(room_id))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer<LiveVideoUrl> { liveVideoUrl -> listen.getVideoUrlSuccess(liveVideoUrl) }, Consumer<Throwable> { t -> listen.getVideoUrlError(t) })
    }
}