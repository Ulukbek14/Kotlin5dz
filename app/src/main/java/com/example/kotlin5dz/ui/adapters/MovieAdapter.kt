package com.example.kotlin5dz.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.kotlin5dz.databinding.ItemMovieBinding
import com.example.kotlin5dz.model.Movie

class MovieAdapter(private val listMovie: List<Movie>, private val listener: (Int) -> Unit) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(movie: Movie) {
            binding.apply {
                itemText.text = movie.name
                itemImage.load(movie.image.original) {
                    crossfade(true)
                    crossfade(1000)
                }
                itemView.setOnClickListener {
                    listener(movie.id)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        return ViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        holder.onBind(listMovie[position])
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }
}