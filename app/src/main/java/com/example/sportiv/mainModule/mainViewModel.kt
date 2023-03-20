package com.example.sportiv.mainModule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportiv.common.ResultResponse
import com.example.sportiv.common.Results
import kotlinx.coroutines.launch
import retrofit2.Response

class mainViewModel: ViewModel() {

    private val interactor = mainInteractor()


    private var result =  MutableLiveData<Response<Results>>()


    fun setResult(res: Response<Results>){
        result.value = res
    }

    fun getResult(): LiveData<Response<Results>>{
        return result
    }

    fun getAllResults(date: String, api_key: String){
        viewModelScope.launch {

            var resultServer = interactor.getAllResults(date,api_key)
            result.value = resultServer
        }
    }

}