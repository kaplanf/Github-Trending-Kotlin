package com.android.githubtrendingkotlin.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.android.githubtrendingkotlin.R
import com.android.githubtrendingkotlin.base.view.BaseActivity
import com.android.githubtrendingkotlin.model.Repository
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_repository.*

/**
 * Created by kaplanf on 6.03.2018.
 */
class DetailActivity : BaseActivity() {

    val descMessage: String = "Description: "
    val forkMessage: String = "Fork Count: "
    val watcherMessage: String = "Watcher Count: "
    val openIssueCountMessage: String = "Open Issues: "
    val repoNameMessage: String = "Repository Name: "
    val ownerNameMessage: String = "Owner: "

    companion object {
        private const val REPO = "repo"

        fun newIntent(context: Context, repository: Repository): Intent =
                Intent(context, DetailActivity::class.java).apply {
                    putExtra(REPO, repository)
                }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        showRepository(intent.extras.get(REPO) as Repository)
    }

    fun showRepository(repository: Repository) {
        detailOwnerName.text = "${ownerNameMessage}" + repository.owner.login
        detailDescription.text = "${descMessage}" + repository.description
        detailForks.text = "${forkMessage}" + repository.forks.toString()
        detailWatchers.text = "${watcherMessage}" + repository.watchers.toString()
        detailOpenIssues.text = "${openIssueCountMessage}" + repository.open_issues_count.toString()
        detailRepoName.text = "${repoNameMessage}" + repository.name
        Glide.with(this)
                .load(repository.owner.avatar_url)
                .asBitmap()
                .centerCrop()
                .into(detailOwnerImage)
    }

    override fun onFragmentAttached() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFragmentDetached(tag: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}