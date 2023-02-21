package com.example.roomdatabase

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabase.Adapter.FoodAdapter
import com.example.roomdatabase.Database.RoomDB
import com.example.roomdatabase.databinding.ActivityShowBinding

class ShowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding=ActivityShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db=RoomDB.getInstance(this)

        var list=db.foods().getFood()

        binding.recycle.layoutManager=LinearLayoutManager(this)
        adapter= FoodAdapter(list)
        binding.recycle.adapter= adapter
    }

    companion object{

        @SuppressLint("StaticFieldLeak")
        lateinit var  adapter: FoodAdapter
        lateinit var  binding: ActivityShowBinding
        lateinit var db:RoomDB

        fun update(){
            var list=db.foods().getFood()
            adapter= FoodAdapter(list)
            binding.recycle.adapter= adapter
        }
    }
}