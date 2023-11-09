package com.example.projekuts

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.projekuts.databinding.ProfileBinding

class ProfileFragment : Fragment() {
    private var binding: ProfileBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProfileBinding.inflate(inflater, container, false)
        val view = binding?.root

        // Temukan button berdasarkan ID
        val buttonBahaya = view?.findViewById<Button>(R.id.logout) // Menambahkan Button
        val buttonDetail = view?.findViewById<Button>(R.id.personaldetail) // Menambahkan Button

        // Tambahkan OnClickListener pada button
        buttonBahaya?.setOnClickListener {
            // Tindakan yang akan dilakukan ketika tombol ditekan, contohnya:
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }
        buttonDetail?.setOnClickListener {
            // Tindakan yang akan dilakukan ketika tombol ditekan, contohnya:
            val intent = Intent(activity, ProfileFragment::class.java)
            startActivity(intent)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
