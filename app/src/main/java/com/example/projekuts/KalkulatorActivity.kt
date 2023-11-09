package com.example.projekuts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.TextUtils
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.projekuts.databinding.ActivityKalkulatorBinding
import org.mariuszgromada.math.mxparser.Expression

class KalkulatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKalkulatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKalkulatorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Mengatur onClickListeners untuk tombol-tombol
        binding.buttonClear.setOnClickListener {
            clearInput()
        }

        binding.buttonBracketLeft.setOnClickListener {
            addToInputText("(")
        }

        binding.buttonBracketRight.setOnClickListener {
            addToInputText(")")
        }

        binding.button0.setOnClickListener {
            addToInputText("0")
        }

        binding.button1.setOnClickListener {
            addToInputText("1")
        }

        binding.button2.setOnClickListener {
            addToInputText("2")
        }

        binding.button3.setOnClickListener {
            addToInputText("3")
        }

        binding.button4.setOnClickListener {
            addToInputText("4")
        }

        binding.button5.setOnClickListener {
            addToInputText("5")
        }

        binding.button6.setOnClickListener {
            addToInputText("6")
        }

        binding.button7.setOnClickListener {
            addToInputText("7")
        }

        binding.button8.setOnClickListener {
            addToInputText("8")
        }

        binding.button9.setOnClickListener {
            addToInputText("9")
        }

        binding.buttonDot.setOnClickListener {
            addToInputText(".")
        }

        binding.buttonDiv.setOnClickListener {
            addToInputText("/")
        }

        binding.buttonAddtion.setOnClickListener {
            addToInputText("+")
        }

        binding.buttonKali.setOnClickListener {
            addToInputText("*")
        }

        binding.buttonSub.setOnClickListener {
            addToInputText("-")
        }

        binding.buttonEquals.setOnClickListener {
            showResult()
        }
    }

    private fun addToInputText(buttonValue: String) {
        val currentText = binding.input.text.toString()
        binding.input.setText("$currentText$buttonValue")
    }

    private fun clearInput() {
        binding.input.text = ""
        binding.output.text = ""
    }

    private fun showResult() {
        val expression = binding.input.text.toString()

        if (TextUtils.isEmpty(expression)) {
            Toast.makeText(this, "Input is empty", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                binding.output.text = "Error"
                binding.output.setTextColor(ContextCompat.getColor(this, R.color.purple_200))
            } else {
                binding.output.text = String.format("%.2f", result)
                binding.output.setTextColor(ContextCompat.getColor(this, R.color.purple_200))
            }
        } catch (e: Exception) {
            binding.output.text = "Error"
            binding.output.setTextColor(ContextCompat.getColor(this, R.color.purple_200))
        }
    }
}
