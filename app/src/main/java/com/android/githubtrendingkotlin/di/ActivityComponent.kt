package com.android.githubtrendingkotlin.di

import com.android.githubtrendingkotlin.ui.detail.DetailActivity
import com.android.githubtrendingkotlin.ui.main.view.MainActivity
import com.android.githubtrendingkotlin.ui.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by kaplanf on 5.03.2018.
 */
@Module
abstract class ActivityComponent {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector()
    abstract fun bindDetailActivity(): DetailActivity

}