package com.example.retrofitwithmvvm.ViewMdodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.w3c.dom.Text

class ViewModleLogin: ViewModel() {

    val TextChange=MutableLiveData<String>("this value")

    val myLiveData: LiveData<String>
        get() = TextChange

   fun upDataValue(){
        TextChange.value="Hello Meer Hadi"

    }
}