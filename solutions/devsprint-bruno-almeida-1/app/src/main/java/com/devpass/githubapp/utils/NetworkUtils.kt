package com.devpass.githubapp.utils

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "https://api.github.com"
object NetworkUtils {
    val gson = GsonBuilder().setLenient().create()

    val getRetrofitInstance = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}