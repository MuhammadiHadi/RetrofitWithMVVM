package com.example.retrofitwithmvvm.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.retrofitwithmvvm.Adapter.RecycleAdapter
import com.example.retrofitwithmvvm.Interface.PropertiesListInterface
import com.example.retrofitwithmvvm.ApiUtils.ApiUtils
import com.example.retrofitwithmvvm.Model.Data
import com.example.retrofitwithmvvm.Repository.PropertiesListRepo
import com.example.retrofitwithmvvm.ViewMdodel.ProListViewModel
import com.example.retrofitwithmvvm.ViewMdodel.ProListViewModelFactory
import com.example.retrofitwithmvvm.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch


class HomeFragment
    : Fragment() {
    private var _binding: FragmentHomeBinding?=null
    private val binding get()=_binding!!
    private lateinit var  viewModel: ProListViewModel
    private lateinit var DataList: ArrayList<Data>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.recycleView.setHasFixedSize(true)
        val propertiesListInterFace= ApiUtils.getPropertiesInstance().create(PropertiesListInterface::class.java)
        val proPertiesListRepo= PropertiesListRepo(propertiesListInterFace)
        viewModel= ViewModelProvider(this, ProListViewModelFactory(proPertiesListRepo)).get(
            ProListViewModel::class.java)
        binding.prograssbar.visibility=View.VISIBLE

        lifecycleScope.launch  {
            val result=propertiesListInterFace.getList()
            if (result.body()!=null){

                DataList = result.body()!!.data

                println("hadi:${DataList}")
                binding.prograssbar.visibility=View.INVISIBLE
                binding.apply {
                    recycleView.layoutManager=GridLayoutManager(context,2)
                    recycleView.setHasFixedSize(true)
                    recycleView.adapter = RecycleAdapter(result.body()!!.data, context)
                }
            }

        }
        return binding.root
    }

}