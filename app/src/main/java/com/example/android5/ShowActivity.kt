package com.example.android5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android5.Adapters.FoodAdapter
import com.example.android5.Database.RoomDB
import com.example.android5.databinding.ActivityShowBinding

class ShowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = RoomDB.getInstance(this)

        var list = db.foods().getFood()

        binding.rcvList.layoutManager = LinearLayoutManager(this)
        adapter = FoodAdapter(list)
        binding.rcvList.adapter = adapter
        
    }

    companion object {
        lateinit var adapter:FoodAdapter
        lateinit var binding:ActivityShowBinding
        lateinit var db:RoomDB
        fun update() {
            var list = db.foods().getFood()
            adapter = FoodAdapter(list)
            binding.rcvList.adapter = adapter
        }

    }

}