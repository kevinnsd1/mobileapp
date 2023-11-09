package com.example.projekuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.projekuts.databinding.ActivityMainBinding

class pilihan : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pilihan)

    }
    fun loginbutton(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }
    fun registerbutton(view: View) {
        val intent = Intent(this, registerActivity::class.java)
        startActivity(intent)

    }
}