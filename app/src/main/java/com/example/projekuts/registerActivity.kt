package com.example.projekuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import com.example.projekuts.databinding.RegisterBinding
import com.google.firebase.auth.FirebaseAuth

class registerActivity : AppCompatActivity() {
    lateinit var binding: RegisterBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = RegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val createNowTextView1: TextView = findViewById(R.id.backlogin)
        val clickAnimation = AnimationUtils.loadAnimation(this, R.anim.click_animation)

// Menambahkan onClickListener ke TextView
        createNowTextView1.setOnClickListener {
            it.startAnimation(clickAnimation)
            val  intent = Intent(this,RegisterBinding::class.java)
            startActivity(intent)
        }
        auth = FirebaseAuth.getInstance()

        binding.buttomregister.setOnClickListener {

            val email = binding.etUsernameregister.text.toString()
            val password = binding.etUsernameregister.text.toString()

            //Validasi email
            if (email.isEmpty()) {
                binding.etUsernameregister.error = "Email Harus Diisi"
                binding.etUsernameregister.requestFocus()
                return@setOnClickListener
            }
            //Validasi email tidak sesuai
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.etUsernameregister.error = "Email Tidak Valid"
                binding.etUsernameregister.requestFocus()
                return@setOnClickListener
            }

            //Validasi password
            if (password.isEmpty()) {
                binding.passwordregister.error = "Password Harus Diisi"
                binding.passwordregister.requestFocus()
                return@setOnClickListener
            }
            if (password.length < 6) {
                binding.passwordregister.error = "Password Minimal 6"
                binding.passwordregister.requestFocus()
                return@setOnClickListener
            }

            RegisterFirebase(email, password)

            val createNowTextView: TextView = findViewById(R.id.backlogin)
            val clickAnimation = AnimationUtils.loadAnimation(this, R.anim.click_animation)

            // Menambahkan onClickListener ke TextView
            createNowTextView.setOnClickListener {
                // Memulai animasi saat TextView diklik
                it.startAnimation(clickAnimation)

                // Kode yang akan dijalankan saat TextView diklik
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun RegisterFirebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this, "Register Berhasil", Toast.LENGTH_SHORT).show()
                    val intent =Intent(this,MainActivity::class.java)
                    startActivity(intent)

                }else{
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}