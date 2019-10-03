package com.example.concurrencytestapi.di

import com.example.concurrencytestapi.network.ApiServices
import com.example.concurrencytestapi.repository.ConcurrencyRepository
import com.example.concurrencytestapi.repository.ConcurrencyRepositoryImpl
import dagger.Module
import dagger.Provides

/**
 * @author Created by Arun
 * A RepositoryModule will be used through dagger.
*/
@Module
class RepositoryModule {
    @Provides
    fun getNewsRepo(api: ApiServices) : ConcurrencyRepository = ConcurrencyRepositoryImpl(api)

}