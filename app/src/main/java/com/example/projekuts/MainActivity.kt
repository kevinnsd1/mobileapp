package com.example.projekuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import com.example.projekuts.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        val createNowTextView: TextView = findViewById(R.id.register)
        val createNowTextView1: TextView = findViewById(R.id.tv_forget)
        val clickAnimation = AnimationUtils.loadAnimation(this, R.anim.click_animation)

// Menambahkan onClickListener ke TextView
        createNowTextView1.setOnClickListener {
            it.startAnimation(clickAnimation)
            val  intent = Intent(this,forgotpassword::class.java)
            startActivity(intent)
        }



        createNowTextView.setOnClickListener {
            // Memulai animasi saat TextView diklik
            it.startAnimation(clickAnimation)


            // Kode yang akan dijalankan saat TextView diklik
            val intent = Intent(this, registerActivity::class.java)
            startActivity(intent)
        }
        binding.login.setOnClickListener {

            val email = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            //Validasi email
            if (email.isEmpty()) {
                binding.etUsername.error = "Email Harus Diisi"
                binding.etUsername.requestFocus()
                return@setOnClickListener
            }
            //Validasi email tidak sesuai
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.etUsername.error = "Email Tidak Valid"
                binding.etUsername.requestFocus()
                return@setOnClickListener
            }

            //Validasi password
            if (password.isEmpty()) {
                binding.etPassword.error = "Password Harus Diisi"
                binding.etPassword.requestFocus()
                return@setOnClickListener
            }
            if (password.length < 6) {
                binding.etPassword.error = "Password Minimal 6"
                binding.etPassword.requestFocus()
                return@setOnClickListener
            }

            LoginFirebase(email, password)





        }
    }

    private fun LoginFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this, "Selamat Datang $email", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,menu::class.java)
                    startActivity(intent)

                }else{
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }


    }

}