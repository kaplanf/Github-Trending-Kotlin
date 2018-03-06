package com.android.githubtrendingkotlin.base.interactor

import com.android.githubtrendingkotlin.api.ApiHelper
import com.android.githubtrendingkotlin.util.SchedulerProvider

/**
 * Created by kaplanf on 5.03.2018.
 */
open class BaseInteractor() : MvpInteractor {

    protected lateinit var apiHelper: ApiHelper
    protected lateinit var schedulerProvider: SchedulerProvider

    constructor(apiHelper: ApiHelper, schedulerProvider: SchedulerProvider) : this() {
        this.apiHelper = apiHelper
        this.schedulerProvider = schedulerProvider
    }
}