package com.example.concurrencytestapi.di

import com.example.concurrencytestapi.ui.MainActivity
import com.example.concurrencytestapi.ui.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeMainActivity(): MainActivity
}