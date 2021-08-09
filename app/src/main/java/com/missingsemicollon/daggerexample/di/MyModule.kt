package com.missingsemicollon.daggerexample.di

import com.missingsemicollon.daggerexample.network.ApiClient
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class MyModule {

    @Provides
    @Singleton
    fun provideApiClient(): ApiClient {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiClient::class.java)
    }

}