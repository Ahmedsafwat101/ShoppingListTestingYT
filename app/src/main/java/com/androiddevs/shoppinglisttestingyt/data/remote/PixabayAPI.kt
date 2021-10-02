package com.androiddevs.shoppinglisttestingyt.data.remote

import com.androiddevs.shoppinglisttestingyt.BuildConfig
import com.androiddevs.shoppinglisttestingyt.data.remote.responses.ImageResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayAPI {

    @GET("/api/")
    suspend fun searchForImage(
        @Query(value = "q") searchQuery: String,
        @Query(value = "key") apiKey: String = BuildConfig.API_KEY,
    ):ImageResponse
}