package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.*
import com.udacity.shoestore.viewmodel.ShoeViewModel
import kotlinx.android.synthetic.main.item_shoe.view.*
import timber.log.Timber

class ShoeDetailFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()

    private val binding by lazy {
        FragmentShoeDetailBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel.resetNewShoe()

        binding.viewModel = viewModel

        // save button
        binding.saveButton.setOnClickListener {

            if (viewModel.addNewShoe()) {

               it.findNavController().navigate(
                   ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
               )

           } else {
               Snackbar.make(
                   requireView(),
                   getString(R.string.incomplete_text),
                   Snackbar.LENGTH_LONG)
                   .show()
           }
        }

        // cancel button
        binding.cancelButton.setOnClickListener {
            it.findNavController().navigate(
                ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
            )
        }


        return binding.root
    }
}