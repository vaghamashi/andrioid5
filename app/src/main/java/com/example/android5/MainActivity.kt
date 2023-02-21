package com.example.android5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android5.Database.RoomDB
import com.example.android5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var db = RoomDB.getInstance(this)

        binding.btnAdd.setOnClickListener {

            var food = FoodEntity(binding.edtName.text.toString(),binding.edtPrice.text.toString().toInt(),binding.rtfood.rating)
            db.foods().addFood(food)

        }


    }
}