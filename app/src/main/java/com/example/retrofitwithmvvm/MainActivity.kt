package com.example.retrofitwithmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle



class MainActivity : AppCompatActivity() {
//    private lateinit var  viewModel:ProListViewModel
//    lateinit var DataList: ArrayList<Data>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val recycleviewview=this.findViewById<RecyclerView>(R.id.recycleView)

//        val adapter=ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mutableListOf())

//        recycleviewview.layoutManager = GridLayoutManager(this,2)
//        recycleviewview.setHasFixedSize(true)
//
//        val propertiesListInterFace= ApiUtils.getPropertiesInstance().create(PropertiesListInterface::class.java)
//
//        var proPertiesListRepo=PropertiesListRepo(propertiesListInterFace)
//
//        viewModel=ViewModelProvider(this,ProListViewModelFactory(proPertiesListRepo)).get(ProListViewModel::class.java)
////        viewModel.PropertiesListItem.observe(this,{
//
//            it.data.iterator().forEach {
//                DataList =it.city
//               recycleviewview.adapter = RecycleAdapter(it.city.toString(), this)
////                adapter.add(it.city)
////                listview.adapter=adapter
//            }
//        })
//        GlobalScope.launch  {
//            val result=propertiesListInterFace.getList()
//            runOnUiThread {
//                if (result.body()!=null){
////                    result.body()!!.data.iterator().forEach {
//                        DataList = result.body()!!.data
//                        recycleviewview.adapter = RecycleAdapter(result.body()!!.data, this)
////                        Log.d("User","name:${it.city}")
//                    }
////                }
//
//            }
//
//
//
//
//        }







    }
}