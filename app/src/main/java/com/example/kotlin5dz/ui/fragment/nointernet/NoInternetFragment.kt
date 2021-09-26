package com.example.kotlin5dz.ui.fragment.nointernet

import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin5dz.R
import com.example.kotlin5dz.base.BaseFragmentMyVersion
import com.example.kotlin5dz.databinding.FragmentNoInternetBinding
import com.example.kotlin5dz.newtork.NetworkIsConnect

class NoInternetFragment :
    BaseFragmentMyVersion<FragmentNoInternetBinding>(R.layout.fragment_no_internet) {

    override val binding by viewBinding(FragmentNoInternetBinding::bind)

    override fun setupView() {
        NetworkIsConnect(context ?: return).observe(viewLifecycleOwner, { isConnect ->
            if (isConnect == true) {
                findNavController().navigateUp()
            }
        }
        )
    }
}