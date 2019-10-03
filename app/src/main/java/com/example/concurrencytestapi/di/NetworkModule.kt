package com.example.concurrencytestapi.di

import com.example.concurrencytestapi.network.ApiServices
import com.example.concurrencytestapi.network.LiveDataCallAdapterFactory
import com.example.concurrencytestapi.network.SupportInterceptor
import com.example.concurrencytestapi.utils.Constant
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author Created by Arun
 * A NetworkModule will be used through dagger to create retrofit object for fetching API.
 */
@Module
class NetworkModule {

    @Provides
    fun provideNewsApi(retrofit: Retrofit) = retrofit.create(ApiServices::class.java)

    /**
    * Used to create object of retrofit with OkHttpClient.
    * @param OkHttpClient
    * */
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()


    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.HEADERS
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(interceptor)
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(SupportInterceptor())
            //.authenticator(SupportInterceptor())
        return builder.build()
    }
}