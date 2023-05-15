package com.example.retrofitwithmvvm.ViewMdodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitwithmvvm.Model.PropertiesList
import com.example.retrofitwithmvvm.Repository.PropertiesListRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProListViewModel(private  val ProRepo:PropertiesListRepo) :ViewModel(){

    init {
        viewModelScope.launch (Dispatchers.IO){
            ProRepo.getListItem()
        }
    }

     val PropertiesListItem: LiveData<PropertiesList>
     get() = ProRepo.propertiesLiveData
}