package com.example.concurrencytestapi.network

import androidx.lifecycle.LiveData
import com.example.concurrencytestapi.model.ItemModel
import retrofit2.http.GET

/**
 * @author Created by Arun
 * A ApiService Interface that helps to call Retrofit.
 **/
interface ApiServices {

    @GET("db")
    fun getProfessionData(): LiveData<ApiResponse<ItemModel>>
}