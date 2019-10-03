package com.example.concurrencytestapi.network

import okhttp3.Interceptor
import okhttp3.Response

/**
 *@author Created by Arun
 * Secondary helper interceptor to skip interceptor headers over Data Module
 */

class SupportInterceptor: Interceptor {

    /**
     * Interceptor class for setting of the headers for every request
     */
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Content-Type", "application/json; charset=utf-8")
            .addHeader("Accept", "application/json")
            .build()
        return chain.proceed(request)
    }
}