package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {
        _shoeList.value = mutableListOf()
        mockData()
    }

    fun addShoe(data: Shoe) {
        _shoeList.value!!.add(data)
    }

    private fun mockData() {
        var count = 1
        while (count <= 3) {
            val shoe = Shoe("Shoe $count", 7.0, "Company $count", "Shoe Desc $count")
            addShoe(shoe)
            ++count
        }
    }
}