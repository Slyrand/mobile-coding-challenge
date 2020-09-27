package com.yogasolo.data.core

import com.google.gson.GsonBuilder
import com.yogasolo.data.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {

    companion object {
        fun <S> createService(serviceClass: Class<S>): S {
            val httpClient = OkHttpClient.Builder()

            with(httpClient) {
                readTimeout(10, TimeUnit.SECONDS)
                connectTimeout(10, TimeUnit.SECONDS)
            }

            val retrofit = getRetrofitClient(httpClient.build())
            return retrofit.create(serviceClass)
        }

        private fun getRetrofitClient(okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .client(okHttpClient)
                .build()
        }
    }
}