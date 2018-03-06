package com.android.githubtrendingkotlin.ui.main

import com.android.githubtrendingkotlin.ui.main.interactor.MainInteractor
import com.android.githubtrendingkotlin.ui.main.interactor.MainMvpInteractor
import com.android.githubtrendingkotlin.ui.main.presenter.MainMvpPresenter
import com.android.githubtrendingkotlin.ui.main.presenter.MainPresenter
import com.android.githubtrendingkotlin.ui.main.view.MainMvpView
import dagger.Module
import dagger.Provides

/**
 * Created by kaplanf on 5.03.2018.
 */
@Module
class MainActivityModule {
    @Provides
    internal fun provideMainInteractor(mainInteractor: MainInteractor): MainMvpInteractor = mainInteractor

    @Provides
    internal fun provideMainPresenter(mainPresenter: MainPresenter<MainMvpView, MainMvpInteractor>)
            : MainMvpPresenter<MainMvpView, MainMvpInteractor> = mainPresenter


}