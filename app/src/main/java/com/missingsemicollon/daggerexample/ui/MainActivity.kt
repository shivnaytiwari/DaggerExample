package com.missingsemicollon.daggerexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.missingsemicollon.daggerexample.R
import com.missingsemicollon.daggerexample.component
import com.missingsemicollon.daggerexample.network.ApiClient
import com.missingsemicollon.daggerexample.network.User
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var apiClient: ApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component.inject(this)
        val call = apiClient.getData()
        call.enqueue(object : Callback<ArrayList<User>> {
            override fun onResponse(
                call: Call<ArrayList<User>>,
                response: Response<ArrayList<User>>
            ) {
                Timber.e("onResponse : ${response.body()}")
                rv_users.adapter = UsersAdapter(response.body())
            }

            override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                Timber.e("onFailure : ${t.message}")
            }
        })

    }
}