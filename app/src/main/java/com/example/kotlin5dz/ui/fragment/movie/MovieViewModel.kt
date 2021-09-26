package com.example.kotlin5dz.ui.fragment.movie

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kotlin5dz.api.RetrofitClient
import com.example.kotlin5dz.base.BaseViewModel
import com.example.kotlin5dz.model.Movie
import kotlinx.coroutines.launch

class MovieViewModel : BaseViewModel() {

    val movieList = MutableLiveData<List<Movie>>()

    fun getMovies () {
        uiScope.launch {
            RetrofitClient.apiService.getMovies().let {
                if (it.isSuccessful) {
                    movieList.value = it.body()
                }  else {
                    Log.e("tag", "movie : Error ${it.code()}")
                }
            }
        }
    }
}