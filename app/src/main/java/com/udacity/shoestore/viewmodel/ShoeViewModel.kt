package com.udacity.shoestore.viewmodel

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

    fun addShoe(name: String, size: Double, company: String, description: String) {
        val shoe = Shoe(name, size, company, description)
        _shoeList.value!!.add(shoe)
    }

    private fun mockData() {
        var count = 1
        while (count <= 3) {
            addShoe("Shoe $count", 7.0, "Company $count", "Shoe Desc $count")
            ++count
        }
    }
}