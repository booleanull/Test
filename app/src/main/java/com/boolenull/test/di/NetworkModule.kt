package com.boolenull.test.di

import com.boolenull.test.data.ApiService
import com.boolenull.test.utils.BASE_URL
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun getGsonConvertFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(GsonBuilder().setLenient().create())
    }

    @Provides
    @Singleton
    fun getRxJava2Call(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    @Singleton
    fun getRetrofit(gsonConverterFactory: GsonConverterFactory, rxJava2CallAdapterFactory: RxJava2CallAdapterFactory): ApiService {
        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .addConverterFactory(gsonConverterFactory)
                .baseUrl(BASE_URL)
                .build()
        return retrofit.create(ApiService::class.java)
    }
}