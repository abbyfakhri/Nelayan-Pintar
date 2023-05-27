package com.freakeinstein.pelaut

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.freakeinstein.pelaut.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val navView:BottomNavigationView = findViewById(R.id.bottom_navigation)

        val navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.navigation_home,R.id.navigation_details,R.id.navigation_account
        ).build()

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        /*
        BottomNavigationView.OnNavigationItemReselectedListener{ item ->
            when(item.itemId){
                R.id.home ->{
                    Toast.makeText(this@MainActivity,"click main menu",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.detail ->{
                    Toast.makeText(this@MainActivity,"click detail menu",Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                    true
                }
                R.id.account -> {
                    true
                }
                else -> false
            }
        }

         */

    }




}