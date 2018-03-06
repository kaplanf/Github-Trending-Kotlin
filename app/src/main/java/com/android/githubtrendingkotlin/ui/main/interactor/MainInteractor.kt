package com.android.githubtrendingkotlin.ui.main.interactor

import com.android.githubtrendingkotlin.api.ApiHelper
import com.android.githubtrendingkotlin.base.interactor.BaseInteractor
import com.android.githubtrendingkotlin.model.GithubResponse
import com.android.githubtrendingkotlin.util.SchedulerProvider
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by kaplanf on 5.03.2018.
 */
class MainInteractor @Inject internal constructor(apiHelper: ApiHelper, schedulerProvider: SchedulerProvider) : BaseInteractor(apiHelper = apiHelper,schedulerProvider = schedulerProvider), MainMvpInteractor {
     override fun getRepos(sort: String, order: String, query: String): Observable<GithubResponse> = apiHelper.getTrendingRepositories(sort,order, query)

}


