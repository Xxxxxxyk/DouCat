package com.xxxxxx_yk.doucat.presenter

import com.xxxxxx_yk.doucat.interfaces.APIDoc
import com.xxxxxx_yk.doucat.interfaces.BasePresenter
import com.xxxxxx_yk.doucat.interfaces.GetBestHotListener
import com.xxxxxx_yk.doucat.model.BestHot
import com.xxxxxx_yk.doucat.services.RetrofitSingleton
import com.xxxxxx_yk.doucat.utils.BaseParams
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

/**
 * Created by 惜梦哥哥 on 2018/2/1.
 */
class GetBestHotPresenter(listener : GetBestHotListener) : BasePresenter{

    private var listen = listener

    override fun loadDate() {
        RetrofitSingleton.get()
                .initServices()
                .create(APIDoc::class.java)
                .getBestHot(BaseParams.getBaseParams())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer<BestHot> { bestHot -> listen.getBestHotSuccess(bestHot)} , Consumer<Throwable>{ t -> listen.getBestHotError(t)})
    }
}