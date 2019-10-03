package com.example.concurrencytestapi.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.concurrencytestapi.repository.ConcurrencyRepository

/**
 * @author Created by Arun
 * ViewModel Factory class to call API using live Data.
 */
class MainActivityViewModelFactory constructor(val repository: ConcurrencyRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}