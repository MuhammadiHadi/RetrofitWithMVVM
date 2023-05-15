package com.example.retrofitwithmvvm.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitwithmvvm.Model.photoDataClass
import com.example.retrofitwithmvvm.Model.photoDataClassItem
import com.example.retrofitwithmvvm.R

class MyImageAdapter(private var ImageList : List<photoDataClassItem> , userall : Context?) :
    RecyclerView.Adapter<MyImageAdapter .MyViewHodler>() {
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): MyViewHodler {
        context = parent.context
        val itemlist =
            LayoutInflater.from(parent.context).inflate(R.layout.image_view_item , parent , false)
        return MyViewHodler(itemlist)
    }

    override fun onBindViewHolder(holder: MyViewHodler , position: Int) {
        Glide.with(context).
        load(ImageList[position].thumbnailUrl).
        into(holder.imageview)



    }

    override fun getItemCount(): Int{
        return  ImageList.size
    }
    class MyViewHodler(itemview: View): RecyclerView.ViewHolder(itemview){

        var imageview: ImageView =itemview.findViewById<ImageView>(R.id.image_view)




    }

}