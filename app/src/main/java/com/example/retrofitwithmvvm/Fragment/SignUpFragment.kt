package com.example.retrofitwithmvvm.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.retrofitwithmvvm.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {

    private   var _binding: FragmentSignUpBinding?=null
     private  val binding get()=_binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding= FragmentSignUpBinding.inflate(inflater,container,false)



        return binding.root
    }


}