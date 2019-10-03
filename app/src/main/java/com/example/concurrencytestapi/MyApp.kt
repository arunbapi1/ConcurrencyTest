package com.example.concurrencytestapi

import android.app.Activity
import android.app.Application
import com.example.concurrencytestapi.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * @author Created by Arun
 * Application class.
 */
class MyApp : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector


    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.
            builder().create(this).inject(this)
    }
}