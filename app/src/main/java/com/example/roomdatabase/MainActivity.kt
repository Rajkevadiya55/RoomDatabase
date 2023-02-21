package com.example.roomdatabase

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomdatabase.Database.RoomDB
import com.example.roomdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

      var db=RoomDB.getInstance(this)


        binding.add.setOnClickListener {
            startActivity(Intent(this,ShowActivity::class.java))
        }

        binding.show.setOnClickListener {
            var food=FoodEntry(binding.edtname.toString(),binding.edtprice.text.toString().toInt(),binding.rating.rating)
          db.foods().addFood(food)
        }
    }
}