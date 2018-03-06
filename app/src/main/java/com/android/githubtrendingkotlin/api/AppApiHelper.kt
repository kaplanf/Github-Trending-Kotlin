package com.android.githubtrendingkotlin.api

import com.android.githubtrendingkotlin.model.GithubResponse
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

/**
 * Created by kaplanf on 5.03.2018.
 */
class AppApiHelper @Inject constructor() : ApiHelper {

    private val apiHelper: ApiHelper

    init {

        val gson = GsonBuilder().create()

        val retrofit: Retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://api.github.com/")
                .build()

        apiHelper = retrofit.create(ApiHelper::class.java)
    }

    override fun getTrendingRepositories(sort: String, order: String, query: String): Observable<GithubResponse> =
            apiHelper.getTrendingRepositories(sort,order,query)

}

