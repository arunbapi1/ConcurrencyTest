package com.example.concurrencytestapi.ui

import com.example.concurrencytestapi.repository.ConcurrencyRepository
import dagger.Module
import dagger.Provides

/**
 * @author Created by Arun
 * Module class to be used to fetch data which is accessible through dagger.
 */
@Module
class MainActivityModule {

    @Provides
    internal fun provideViewModelFactory(repository: ConcurrencyRepository) : MainActivityViewModelFactory
            = MainActivityViewModelFactory(repository)
}