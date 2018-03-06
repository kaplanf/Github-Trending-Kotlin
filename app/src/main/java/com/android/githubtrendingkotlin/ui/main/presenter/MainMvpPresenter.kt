package com.android.githubtrendingkotlin.ui.main.presenter

import com.android.githubtrendingkotlin.base.presenter.MvpPresenter
import com.android.githubtrendingkotlin.ui.main.interactor.MainMvpInteractor
import com.android.githubtrendingkotlin.ui.main.view.MainMvpView

/**
 * Created by kaplanf on 5.03.2018.
 */
interface MainMvpPresenter<V : MainMvpView, I : MainMvpInteractor> : MvpPresenter<V, I> {

    fun loadRepos(sort: String, order: String, query: String)


}