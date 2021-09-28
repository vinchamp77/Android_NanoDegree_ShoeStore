package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.*
import kotlinx.android.synthetic.main.item_shoe.view.*
import timber.log.Timber

class ShoeListFragment : Fragment() {

    private val viewModel: ShoeViewModel by viewModels()
    private val binding by lazy {
        FragmentShoelistBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel.shoeList.observe(viewLifecycleOwner) {
            Timber.i("observer is called")
            for (shoe in it) {
                addShoe(shoe.name)
            }
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_logout ->
                findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addShoe(shoeName: String) {
        val view = layoutInflater.inflate(R.layout.item_shoe, null)
        view.textView.text = shoeName
        binding.shoeList.addView(view.textView)
    }
}