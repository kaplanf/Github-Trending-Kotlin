package com.android.githubtrendingkotlin.model

import java.io.Serializable

/**
 * Created by kaplanf on 5.03.2018.
 */

data class GithubResponse(
        val items: List<Repository>
)

data class Repository(
        val id: Long,
        val name: String,
        val owner: Owner,
        val description: String,
        val url: String,
        val forks : Int,
        val watchers : Int,
        val open_issues_count: Int
) : Serializable

data class Owner(
        val login: String,
        val id: Long,
        val avatar_url: String,
        val url: String
) : Serializable