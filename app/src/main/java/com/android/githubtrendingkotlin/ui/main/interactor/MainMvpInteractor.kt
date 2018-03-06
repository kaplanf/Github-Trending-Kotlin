package com.android.githubtrendingkotlin.ui.main.interactor

import com.android.githubtrendingkotlin.base.interactor.MvpInteractor
import com.android.githubtrendingkotlin.model.GithubResponse
import com.android.githubtrendingkotlin.model.Repository
import io.reactivex.Observable

/**
 * Created by kaplanf on 5.03.2018.
 */
interface MainMvpInteractor : MvpInteractor {

    fun getRepos(sort: String, order: String, query: String): Observable<GithubResponse>

}