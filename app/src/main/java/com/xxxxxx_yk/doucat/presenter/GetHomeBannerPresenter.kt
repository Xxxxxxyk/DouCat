package com.xxxxxx_yk.doucat.presenter

import com.xxxxxx_yk.doucat.interfaces.APIDoc
import com.xxxxxx_yk.doucat.interfaces.BasePresenter
import com.xxxxxx_yk.doucat.interfaces.GetHomeBannerListener
import com.xxxxxx_yk.doucat.model.HomeBanners
import com.xxxxxx_yk.doucat.services.RetrofitSingleton
import com.xxxxxx_yk.doucat.utils.BaseParams
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

/**
 * Created by 惜梦哥哥 on 2018/1/26.
 */
class GetHomeBannerPresenter(listener: GetHomeBannerListener) : BasePresenter {

    private var listener = listener

    override fun loadDate() {
        RetrofitSingleton.get()
                .initServices()
                .create(APIDoc::class.java)
                .getHomeBanners(BaseParams.getBaseParams())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer<HomeBanners> { homeBanner -> listener.getHomeBannerSuccess(homeBanner) }, Consumer<Throwable> { t -> listener.getHomeBannerError(t) })
    }
}