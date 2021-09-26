package com.example.kotlin5dz.ui.fragment.movie

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin5dz.R
import com.example.kotlin5dz.base.BaseFragmentMyVersion
import com.example.kotlin5dz.databinding.FragmentMovieBinding
import com.example.kotlin5dz.newtork.NetworkIsConnect
import com.example.kotlin5dz.ui.adapters.MovieAdapter

class MovieFragment : BaseFragmentMyVersion<FragmentMovieBinding>(R.layout.fragment_movie) {

    override val binding by viewBinding(FragmentMovieBinding::bind)
    private val viewModel: MovieViewModel by viewModels()

    override fun initMV() {

        NetworkIsConnect(context ?: return).observe(viewLifecycleOwner, { isConnect ->
            if (isConnect) {
                viewModel.getMovies()
                viewModel.movieList.observe(this, {
                    binding.recView.apply {
                        adapter = MovieAdapter(it, this@MovieFragment::openDetail)
                        layoutManager = GridLayoutManager(requireContext(), 2)
                    }
                })
            } else {
                findNavController().navigate(R.id.noInternetFragment)
            }
        })
    }

    private fun openDetail(id: Int) {
        findNavController().navigate(
            MovieFragmentDirections.actionMovieFragmentToGetDetailFragment(id)
        )
    }
}