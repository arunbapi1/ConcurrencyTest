package com.example.concurrencytestapi.repository

import androidx.lifecycle.LiveData
import com.example.concurrencytestapi.model.ItemModel
import com.example.concurrencytestapi.network.ApiResponse

/**
 * @author Created by Arun
 * Repository Interface to call API using live Data.
 */
interface ConcurrencyRepository {
    fun getAllProfessionData(): LiveData<ApiResponse<ItemModel>>
}