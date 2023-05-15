package com.example.retrofitwithmvvm.ViewMdodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitwithmvvm.Repository.PropertiesListRepo

class ProListViewModelFactory(private  val proRepo:PropertiesListRepo):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProListViewModel(proRepo) as T
    }

}