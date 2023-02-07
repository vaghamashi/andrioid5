package com.example.android5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android5.Adapters.StudentAdapter
import com.example.android5.Database.Database
import com.example.android5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var database: Database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Database(applicationContext)

        binding.btnAdd.setOnClickListener {


//          TODO Get Text in Integer
//            var number:Int = binding.edtMobile.text.toString().toInt()
//            database.addData(
//                binding.edtName.text.toString(),
//                binding.edtSurname.text.toString(),
//                binding.edtAddress.text.toString(),
//                number
//            )

            database.addData(
                binding.edtName.text.toString(),
                binding.edtSurname.text.toString(),
                binding.edtAddress.text.toString()
            )

            binding.btnShow.setOnClickListener {

                var list = database.showData()
                binding.stdLists.layoutManager = LinearLayoutManager(applicationContext)
                binding.stdLists.adapter = StudentAdapter(list)

            }


        }

    }
}