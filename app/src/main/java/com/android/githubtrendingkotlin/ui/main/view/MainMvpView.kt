package com.android.githubtrendingkotlin.ui.main.view

import com.android.githubtrendingkotlin.base.view.MvpView
import com.android.githubtrendingkotlin.model.Repository

/**
 * Created by kaplanf on 6.03.2018.
 */
interface MainMvpView : MvpView {

    fun buildList(repositories : List<Repository>)

}