package com.example.sportiv.common

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SportServices {

    @GET(Constants.RESULTS_URL)
    suspend fun getAllResults(
        @Query("date") date: String,
        @Query("api_key") api_key: String,
    ): Response<Results>

}