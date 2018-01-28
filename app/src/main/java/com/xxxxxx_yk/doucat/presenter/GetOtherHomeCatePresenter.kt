package com.xxxxxx_yk.doucat.presenter

import com.xxxxxx_yk.doucat.interfaces.APIDoc
import com.xxxxxx_yk.doucat.interfaces.BasePresenter
import com.xxxxxx_yk.doucat.interfaces.GetOtherHomeCateListener
import com.xxxxxx_yk.doucat.model.HomeOtherCate
import com.xxxxxx_yk.doucat.services.RetrofitSingleton
import com.xxxxxx_yk.doucat.utils.ParamsUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

/**
 * Created by 惜梦哥哥 on 2018/1/9.
 */
class GetOtherHomeCatePresenter(listener: GetOtherHomeCateListener , identification: String) : BasePresenter {

    private var listen = listener
    private var id = identification

    override fun loadDate() {
        RetrofitSingleton.get()
                .initServices()
                .create(APIDoc::class.java)
                .getOtherHomeCate(ParamsUtils.getHomeCate(id))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer<HomeOtherCate> { homeOtherCate -> listen.getOtherHomeCateSuccess(homeOtherCate) }, Consumer<Throwable> { t -> listen.getOtherHomeCateError(t) })
    }
}