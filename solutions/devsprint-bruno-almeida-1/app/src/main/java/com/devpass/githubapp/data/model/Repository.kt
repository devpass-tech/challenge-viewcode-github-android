package com.devpass.githubapp.data.model

import com.google.gson.annotations.SerializedName

data class Repository(
    @SerializedName("name")
    var name : String,
    @SerializedName("description")
    var description : String?,
    @SerializedName("stargazers_count")
    var stargazersCount : Int?,
    @SerializedName("forks_count")
    var forksCount : Int?,
    @SerializedName("owner")
    var owner : Owner,
    @SerializedName("license")
    var license : License?
)