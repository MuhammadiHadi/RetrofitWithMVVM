package com.example.retrofitwithmvvm.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitwithmvvm.Model.Data
import com.example.retrofitwithmvvm.R



class RecycleAdapter(private var cityList : ArrayList<Data> , context : Context?) :
    RecyclerView.Adapter<RecycleAdapter.MyViewHodler>() {
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): MyViewHodler {
        context = parent.context
        val itemlist =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list , parent , false)
        return MyViewHodler(itemlist)
    }

    override fun onBindViewHolder(holder: MyViewHodler , position: Int) {
        holder.prooerties.text = cityList[position].type
        holder.addreessl.text = cityList[position].country
        holder.price.text= " $${cityList[position].max_price.toString()}"
        Glide.with(context).
        load(cityList[position].image).
        into(holder.imageview)



    }

    override fun getItemCount(): Int{
        return  cityList.size
    }
    class MyViewHodler(itemview: View): RecyclerView.ViewHolder(itemview){

        var imageview: ImageView =itemview.findViewById<ImageView>(R.id.imageView)
        val prooerties: TextView =itemview.findViewById<TextView>(R.id.textView)
        var addreessl: TextView =itemview.findViewById<TextView>(R.id.address)
        var price: TextView =itemview.findViewById<TextView>(R.id.tv_price)



    }

}