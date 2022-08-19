package com.devpass.githubapp.data.model

import com.google.gson.annotations.SerializedName

data class License(
    @SerializedName("name")
    var name : String,
    @SerializedName("key")
    var key : String,
    @SerializedName("url")
    var url : String
)