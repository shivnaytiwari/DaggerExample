package com.missingsemicollon.daggerexample.network

import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {

    @GET("/users")
    fun getData(): Call<ArrayList<User>>

}