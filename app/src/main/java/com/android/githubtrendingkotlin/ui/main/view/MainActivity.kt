package com.android.githubtrendingkotlin.ui.main.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.android.githubtrendingkotlin.R
import com.android.githubtrendingkotlin.base.view.BaseActivity
import com.android.githubtrendingkotlin.model.Repository
import com.android.githubtrendingkotlin.ui.detail.DetailActivity
import com.android.githubtrendingkotlin.ui.main.interactor.MainMvpInteractor
import com.android.githubtrendingkotlin.ui.main.presenter.MainMvpPresenter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import javax.inject.Inject

class MainActivity : BaseActivity(),MainMvpView {

    @Inject
    internal lateinit var presenter: MainMvpPresenter<MainMvpView, MainMvpInteractor>

    private var mAdapter: RepositoriesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onAttach(this)
        initRecyclerView()
        presenter.loadRepos("stars","desc","created:>"+getDaysAgo(7))
    }

    private fun initRecyclerView() {
        mAdapter = RepositoriesAdapter(ArrayList<Repository>(), {
            startActivity(DetailActivity.newIntent(this, it))
        },this)
        mainRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mainRecyclerView.adapter = mAdapter
    }


    override fun buildList(repositories: List<Repository>) {
        mAdapter?.addRepositories(repositories)
        mAdapter?.notifyDataSetChanged()    }

    private fun getDaysAgo(daysAgo: Int): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, -daysAgo)
        var day = calendar.get(Calendar.DAY_OF_MONTH).toString()
        var month = (calendar.get(Calendar.MONTH)+1).toString()
        var year  = calendar.get(Calendar.YEAR).toString()

        if(month.length<2)
            month = "0"+month
        if(day.length<2)
            day = "0"+day
        return year+"-"+month+"-"+day
    }

    override fun onFragmentDetached(tag: String) {

    }


    override fun onFragmentAttached() {
    }
}
