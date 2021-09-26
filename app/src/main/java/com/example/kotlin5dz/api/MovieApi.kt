package com.example.kotlin5dz.api

import com.example.kotlin5dz.model.Movie
import com.example.kotlin5dz.utills.Constant.SHOWS_END_POINT
import com.example.kotlin5dz.utills.Constant.SHOWS_END_POINT_ID
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {

    @GET(SHOWS_END_POINT)
    suspend fun getMovies(): Response<List<Movie>>

    @GET(SHOWS_END_POINT_ID)
    suspend fun getDetailMovies(@Path("id") id: Int): Response<Movie>
}