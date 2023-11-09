package com.example.projekuts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Profile
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        loadFragment(konversi())

        // definisi widget
        var bottomnav = findViewById<BottomNavigationView>(R.id.bottomnavview)
        bottomnav.setOnItemSelectedListener {

            when(it.itemId){

                R.id.konversi-> {
                    loadFragment(konversi())
                    true
                }

                R.id.kalkulator -> {
                    loadFragment(kalkulator())
                    true
                }

                R.id.suhu-> {
                    loadFragment(suhu())
                    true
                }

                R.id.profile-> {
                    loadFragment(profile2())
                    true
                }
                R.id.bmi-> {
                    loadFragment(fragmment_bmi())
                    true
                }

                else -> {false}
            }
        }
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.f_container,fragment)
        transaction.commit()
    }
}