package com.example.kotlin5dz.api

import com.example.kotlin5dz.utills.Constant.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private var retrofit: Retrofit? = null

    private fun getClient(baseUrl: String): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder().
            baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit!!
    }

    val apiService: MovieApi = getClient(BASE_URL).create(MovieApi::class.java)
}