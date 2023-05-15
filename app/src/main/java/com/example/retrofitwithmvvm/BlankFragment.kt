package com.example.retrofitwithmvvm

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitwithmvvm.Adapter.MyImageAdapter
import com.example.retrofitwithmvvm.Interface.PropertiesListInterface
import com.example.retrofitwithmvvm.ApiUtils.ApiUtils
import com.example.retrofitwithmvvm.Model.NewUserModle
import com.example.retrofitwithmvvm.databinding.FragmentBlankBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class BlankFragment : Fragment() {
    private var _binding: FragmentBlankBinding?=null
    private val binding get()= _binding!!


    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentBlankBinding.inflate(inflater,container,false)

//        val adapter= context?.let { ArrayAdapter<String>(it, R.layout.simple_list_item_1, mutableListOf()) }
        val user= ApiUtils.userGet().create(PropertiesListInterface::class.java)

        binding.prograssbar.visibility=View.VISIBLE
        GlobalScope.launch {


            val allUser=user.getUserList().body()
            val handler = Handler(Looper.getMainLooper())
            binding.prograssbar.visibility=View.INVISIBLE
            handler.post {
                if(allUser!=null){
                    val userall=allUser
                    println("AllUser:$userall")
                    binding.apply {
                        listView.layoutManager=LinearLayoutManager(context)
                        listView.setHasFixedSize(true)
                        listView.adapter=MyImageAdapter(userall!!,context)
                    }

                    }
                }
            }



        binding.apply {
            updata.setOnClickListener {
                val upDateUser = NewUserModle(1, "New Name","newusername", "newemail@example.com")
                val result=user.updateUser(1,upDateUser)
                println("hadi khan:${result}")


            }
        }



        return binding.root
    }


}