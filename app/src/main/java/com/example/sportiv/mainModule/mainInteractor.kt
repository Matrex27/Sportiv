package com.example.sportiv.mainModule

import com.example.sportiv.common.Constants
import com.example.sportiv.common.Results
import com.example.sportiv.common.SportServices
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class mainInteractor {


    //Services

    var getResultsService = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(SportServices::class.java)


    suspend fun getAllResults(date: String, api_key: String): Response<Results>{
        return getResultsService.getAllResults(date, api_key)
    }


}