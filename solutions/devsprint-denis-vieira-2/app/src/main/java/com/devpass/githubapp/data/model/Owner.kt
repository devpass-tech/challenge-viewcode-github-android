package com.devpass.githubapp.data.model

import com.google.gson.annotations.SerializedName

data class Owner(
    @SerializedName("login")
    var login : String,
    @SerializedName("avatar_url")
    var avatarUrl : String,
    @SerializedName("url")
    var url : String
)