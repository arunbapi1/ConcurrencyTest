package com.example.concurrencytestapi.di

import dagger.Module

@Module(includes = [NetworkModule::class, RepositoryModule::class])
class AppModule {

}