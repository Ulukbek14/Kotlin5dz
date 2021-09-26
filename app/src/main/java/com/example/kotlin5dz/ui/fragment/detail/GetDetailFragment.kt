package com.example.kotlin5dz.ui.fragment.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.example.kotlin5dz.R
import com.example.kotlin5dz.base.BaseFragmentMyVersion
import com.example.kotlin5dz.databinding.FragmentGetDetailBinding

class GetDetailFragment :
    BaseFragmentMyVersion<FragmentGetDetailBinding>(R.layout.fragment_get_detail) {

    override val binding by viewBinding(FragmentGetDetailBinding::bind)
    private val viewModel: GetDetailViewModel by viewModels()
    private val args: GetDetailFragmentArgs by navArgs()

    var id: Int? = null

    override fun setupView() {
        id = args.model
        getData()
    }

    private fun getData() {
        id?.let { viewModel.getMovieDetail(it) }
        viewModel.movies.observe(viewLifecycleOwner, { getModel ->
            binding.ivMainPoster.load(getModel.image.original) {
                crossfade(true)
                crossfade(1000)
            }
            binding.tvRatingStar.text = getModel.rating.average.toString()
            binding.tvGenresOfFilm.text = getModel.genres.toString()
            binding.tvStatusOfFilm.text = getModel.status
            binding.tvDescriptionText.text = getModel.summary
            binding.tvPremierOfFilm.text = getModel.premiered
            binding.tvLanguageOfFilm.text = getModel.language
            binding.tvEndedOfFilm.text = getModel.ended
        })
    }
}
