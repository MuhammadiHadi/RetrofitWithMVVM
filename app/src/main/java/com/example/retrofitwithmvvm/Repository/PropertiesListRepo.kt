package com.example.retrofitwithmvvm.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitwithmvvm.Interface.PropertiesListInterface
import com.example.retrofitwithmvvm.Model.PropertiesList

class PropertiesListRepo(private  val PropertiesInterface:PropertiesListInterface) {


     private  val propertiesListLiveData=MutableLiveData<PropertiesList>()
     val propertiesLiveData:LiveData<PropertiesList>
                get()=propertiesListLiveData


    suspend fun getListItem(){
        val result=PropertiesInterface.getList()
        if(result.body()!=null){
            propertiesListLiveData.postValue(result.body())
        }
    }


}