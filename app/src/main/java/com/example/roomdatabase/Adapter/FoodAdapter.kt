package com.example.roomdatabase.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.roomdatabase.Database.RoomDB
import com.example.roomdatabase.FoodEntry
import com.example.roomdatabase.R
import com.example.roomdatabase.ShowActivity

class FoodAdapter(list: List<FoodEntry>) : RecyclerView.Adapter<FoodAdapter.FoodHolder>() {
    lateinit var  context: Context
    var foodlist=list



    class FoodHolder(itemView:View):ViewHolder(itemView) {
        var txtid=itemView.findViewById<TextView>(R.id.txtid)
        var txtname=itemView.findViewById<TextView>(R.id.txtname)
        var txtprice=itemView.findViewById<TextView>(R.id.txtprice)
        var fdrating=itemView.findViewById<RatingBar>(R.id.ratfood)
        var imgdelete=itemView.findViewById<ImageView>(R.id.imgDelete)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {
        context=parent.context

        return FoodHolder(LayoutInflater.from(parent.context).inflate(R.layout.std_list,parent,false))
    }

    override fun getItemCount(): Int {
        return  foodlist.size
    }

    override fun onBindViewHolder(holder: FoodHolder, position: Int) {
      var db=RoomDB.getInstance(context)

        holder.txtid.text=foodlist.get(position).id.toString()
        holder.txtname.text=foodlist.get(position).name
        holder.txtprice.text=foodlist.get(position).price.toString()
        holder.fdrating.rating=foodlist.get(position).rating



        holder.imgdelete.setOnClickListener {

            db.foods().deleteFood(foodlist.get(position))
            ShowActivity.update()

        }


    }
}