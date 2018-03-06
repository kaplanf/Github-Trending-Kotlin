package com.android.githubtrendingkotlin.api

import com.android.githubtrendingkotlin.model.GithubResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by kaplanf on 5.03.2018.
 */
interface ApiHelper {

    @GET(ApiConstants.SEARCH)
    fun getTrendingRepositories(@Query(ApiConstants.SORT) sort: String, @Query(ApiConstants.ORDER) order: String,
                                @Query(ApiConstants.QUERY) query: String): Observable<GithubResponse>
}