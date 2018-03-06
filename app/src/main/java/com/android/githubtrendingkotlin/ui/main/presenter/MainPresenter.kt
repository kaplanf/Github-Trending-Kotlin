package com.android.githubtrendingkotlin.ui.main.presenter

import com.android.githubtrendingkotlin.base.presenter.BasePresenter
import com.android.githubtrendingkotlin.ui.main.interactor.MainMvpInteractor
import com.android.githubtrendingkotlin.ui.main.view.MainMvpView
import com.android.githubtrendingkotlin.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by kaplanf on 5.03.2018.
 */
class MainPresenter<V : MainMvpView, I : MainMvpInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), MainMvpPresenter<V, I> {
    override fun onAttach(view: V?) {
        super.onAttach(view)
    }

    override fun loadRepos(sort: String, order: String, query: String) {
        getView()?.showProgress()
        interactor?.let {
            compositeDisposable.add(
                    it.getRepos(sort, order, query)
                            .compose(schedulerProvider.ioToMainObservableScheduler()).doOnError { print(it.toString()) }
                            .subscribe({ githubResponse ->
                                getView()?.let {
                                    it.hideProgress()
                                    it.buildList(githubResponse.items)
                                }
                            }, { err -> println(err) }))
        }
    }


}