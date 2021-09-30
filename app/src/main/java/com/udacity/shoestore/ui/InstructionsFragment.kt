package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentInstructionsBinding.inflate(inflater)

        binding.letsgoButton.setOnClickListener {
            it.findNavController().navigate(
                InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment()
            )
        }

        return binding.root
    }

}