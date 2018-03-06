package com.android.githubtrendingkotlin.base.presenter

import com.android.githubtrendingkotlin.base.interactor.MvpInteractor
import com.android.githubtrendingkotlin.base.view.MvpView

/**
 * Created by kaplanf on 5.03.2018.
 */
interface MvpPresenter<V : MvpView, I : MvpInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?

}