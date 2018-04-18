package com.xxxxxx_yk.doucat.presenter

import com.xxxxxx_yk.doucat.interfaces.APIDoc
import com.xxxxxx_yk.doucat.interfaces.BasePresenter
import com.xxxxxx_yk.doucat.interfaces.GetHomeCateListener
import com.xxxxxx_yk.doucat.model.HomeCate
import com.xxxxxx_yk.doucat.services.RetrofitSingleton
import com.xxxxxx_yk.doucat.utils.BaseParams
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class GetHomeCatePresenter(var listener: GetHomeCateListener) : BasePresenter{
    override fun loadDate() {
        RetrofitSingleton.get()
                .initServices()
                .create(APIDoc::class.java)
                .getHomeCate(BaseParams.getBaseParams())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer<HomeCate> { homeCateList -> listener.getHomeCateSuccess(homeCateList) }, Consumer<Throwable> { t -> listener.getHomeCateError(t) })
    }
}