package com.example.android5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import com.example.android5.Adapters.FragPageAdapter
import com.example.android5.Fragments.CallFragment
import com.example.android5.Fragments.ChatFragment
import com.example.android5.Fragments.StatusFragment
import com.example.android5.R.drawable.*
import com.example.android5.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bindhing = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindhing.root)


        bindhing.menu.setOnClickListener {
            bindhing.drawer.openDrawer(Gravity.LEFT)
        }

        bindhing.navigation.setNavigationItemSelectedListener(object : OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {

                when(item.itemId) {

                    R.id.dashboard->{
                        Toast.makeText(applicationContext, "Dashboard", Toast.LENGTH_SHORT).show()
                    }

                    R.id.setting->{
                        Toast.makeText(applicationContext, "Setting", Toast.LENGTH_SHORT).show()
                    }

                    R.id.profile->{
                        Toast.makeText(applicationContext, "Profile", Toast.LENGTH_SHORT).show()
                    }

                    R.id.about-> {
                        Toast.makeText(applicationContext, "About us", Toast.LENGTH_SHORT).show()
                    }
                }

                return false
            }

        })

        bindhing.pager.adapter = FragPageAdapter(supportFragmentManager)
        bindhing.tabs.setupWithViewPager(bindhing.pager)



    }
}

