package com.example.concurrencytestapi.repository

import androidx.lifecycle.LiveData
import com.example.concurrencytestapi.model.ItemModel
import com.example.concurrencytestapi.network.ApiResponse
import com.example.concurrencytestapi.network.ApiServices
import javax.inject.Inject

/**
 * @author Created by Arun
 * Repository Class to call API using live Data from ViewModel.
 */
class ConcurrencyRepositoryImpl @Inject constructor(val api : ApiServices) : ConcurrencyRepository {

    override fun getAllProfessionData(): LiveData<ApiResponse<ItemModel>> = api.getProfessionData()
}