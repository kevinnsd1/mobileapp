package com.example.projekuts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projekuts.databinding.FragmentKalkulatorBinding
import android.widget.Toast
import androidx.core.content.ContextCompat
import org.mariuszgromada.math.mxparser.Expression


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [kalkulator.newInstance] factory method to
 * create an instance of this fragment.
 */
class kalkulator : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentKalkulatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKalkulatorBinding.inflate(inflater, container, false)
        val view = binding.root

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
            addToInputText("÷")
        }

        binding.buttonAddtion.setOnClickListener {
            addToInputText("+")
        }

        binding.buttonKali.setOnClickListener {
            addToInputText("x")
        }

        binding.buttonSub.setOnClickListener {
            addToInputText("-")
        }

        binding.buttonEquals.setOnClickListener {
            showResult()
        }

        return view
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

        if (expression.isEmpty()) {
            Toast.makeText(requireContext(), "Input is empty", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                binding.output.text = "Error"
                binding.output.setTextColor(ContextCompat.getColor(requireContext(), R.color.purple_200))
            } else {
                binding.output.text = String.format("%.2f", result)
                binding.output.setTextColor(ContextCompat.getColor(requireContext(), R.color.purple_200))
            }
        } catch (e: Exception) {
            binding.output.text = "Error"
            binding.output.setTextColor(ContextCompat.getColor(requireContext(), R.color.purple_200))
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment kalkulator.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            kalkulator().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}