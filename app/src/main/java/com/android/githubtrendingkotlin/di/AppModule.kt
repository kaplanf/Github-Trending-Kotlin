package com.android.githubtrendingkotlin.di

import android.app.Application
import android.content.Context
import com.android.githubtrendingkotlin.api.ApiHelper
import com.android.githubtrendingkotlin.api.AppApiHelper
import com.android.githubtrendingkotlin.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by kaplanf on 5.03.2018.
 */
@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()


}