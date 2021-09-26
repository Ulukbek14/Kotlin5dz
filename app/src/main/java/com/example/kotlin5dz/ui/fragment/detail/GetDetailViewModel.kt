package com.example.kotlin5dz.ui.fragment.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kotlin5dz.api.RetrofitClient
import com.example.kotlin5dz.base.BaseViewModel
import com.example.kotlin5dz.model.Movie
import kotlinx.coroutines.launch

class GetDetailViewModel : BaseViewModel() {

    val movies = MutableLiveData<Movie>()

    fun getMovieDetail(id: Int) {
        uiScope.launch {
            RetrofitClient.apiService.getDetailMovies(id).let {
                if (it.isSuccessful) {
                    movies.value = it.body()
                } else {
                    Log.e("tag", "getMovie : Error ${it.code()}")
                }
            }
        }
    }
}