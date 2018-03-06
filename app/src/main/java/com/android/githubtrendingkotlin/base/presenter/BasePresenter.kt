package com.android.githubtrendingkotlin.base.presenter

import com.android.githubtrendingkotlin.base.interactor.MvpInteractor
import com.android.githubtrendingkotlin.base.view.MvpView
import com.android.githubtrendingkotlin.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by kaplanf on 5.03.2018.
 */
abstract class BasePresenter<V : MvpView, I : MvpInteractor> internal constructor(protected var interactor: I?, protected val schedulerProvider: SchedulerProvider, protected val compositeDisposable: CompositeDisposable) : MvpPresenter<V, I> {

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun getView(): V? = view

    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
        interactor = null
    }

}