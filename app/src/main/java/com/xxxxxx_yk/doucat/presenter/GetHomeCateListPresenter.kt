package com.xxxxxx_yk.doucat.presenter

import com.xxxxxx_yk.doucat.interfaces.APIDoc
import com.xxxxxx_yk.doucat.interfaces.BasePresenter
import com.xxxxxx_yk.doucat.interfaces.GetHomeCateListListener
import com.xxxxxx_yk.doucat.model.HomeCateList
import com.xxxxxx_yk.doucat.services.RetrofitSingleton
import com.xxxxxx_yk.doucat.utils.BaseParams
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

/**
 * Created by 惜梦哥哥 on 2018/1/4.
 */
class GetHomeCateListPresenter(listener: GetHomeCateListListener) : BasePresenter {

    var listen = listener

    override fun loadDate() {
        RetrofitSingleton.get()
                .initServices()
                .create(APIDoc::class.java)
                .getHomeCateList(BaseParams.getBaseParams())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer<HomeCateList> { homeCateList -> listen.showHomeCateListSuccess(homeCateList) }, Consumer<Throwable> { t -> listen.showHomeCateListError(t) })
    }
}