package com.example.concurrencytestapi.di

import com.example.concurrencytestapi.MyApp
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class, ActivityBuilder::class])
interface AppComponent : AndroidInjector<MyApp> {
    @Component.Builder
    abstract  class Builder : AndroidInjector.Builder<MyApp>()

}