package com.example.retrofitwithmvvm.Fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.retrofitwithmvvm.Interface.PropertiesListInterface
import com.example.retrofitwithmvvm.ApiUtils.ApiUtils
import com.example.retrofitwithmvvm.databinding.FragmentUserBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class UserFragment : Fragment() {
   private var _binding:FragmentUserBinding?=null
   private val binding get()= _binding!!


    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding=FragmentUserBinding.inflate(inflater,container,false)

        val adapter= context?.let { ArrayAdapter<String>(it, android.R.layout.simple_list_item_1, mutableListOf()) }
        val user= ApiUtils.getPropertiesInstance().create(PropertiesListInterface::class.java)


        binding.prograssbar.visibility=View.VISIBLE
        GlobalScope.launch {
            val allUser=user.getList()
            val handler = Handler(Looper.getMainLooper())
            binding.prograssbar.visibility=View.INVISIBLE
            handler.post {
                if(allUser.body()!=null){
                    val userall=allUser.body()
                    println("AllUser:$userall")

                    allUser.body()!!.data.iterator().forEach {
                        if (adapter != null) {
                            adapter.add(it.city)
                            binding.lvUser.adapter=adapter
                        }

                    }
                }
            }


        }



        return binding.root
    }


}