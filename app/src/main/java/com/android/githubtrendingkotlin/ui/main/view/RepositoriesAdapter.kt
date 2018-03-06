package com.android.githubtrendingkotlin.ui.main.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.githubtrendingkotlin.R
import com.android.githubtrendingkotlin.model.Repository
import com.bumptech.glide.Glide

import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_repository.*

/**
 * Created by kaplanf on 6.03.2018.
 */
class RepositoriesAdapter(private val repositories: MutableList<Repository>,
                          val onClick: (Repository) -> Unit, val context: Context)
    : RecyclerView.Adapter<RepositoriesAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.bindData(repositories[position], context)
    }

    override fun getItemCount(): Int = repositories.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_repository, parent, false).let {
                    ViewHolder(it, onClick)
                }
    }


    class ViewHolder(override val containerView: View, val onClick: (Repository) -> Unit) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bindData(repository: Repository, context: Context) {
            with(repository) {
                owner_name.text = owner.login
                repo_name.text = name
                Glide.with(context)
                        .load(owner.avatar_url)
                        .asBitmap()
                        .centerCrop()
                        .into(owner_image)
                containerView.setOnClickListener { onClick(this) }
            }
        }
    }


    fun addRepositories(newRepositories: List<Repository>) {
        repositories.addAll(newRepositories)
    }
}