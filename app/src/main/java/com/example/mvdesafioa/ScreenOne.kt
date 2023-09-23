package com.example.mvdesafioa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mvdesafioa.databinding.FragmentScreenOneBinding

class ScreenOne : Fragment() {

    private var _binding: FragmentScreenOneBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentScreenOneBinding.inflate(
        inflater,
        container,
        false
    ).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setButton()
    }

    private fun setButton() {
        val textView = binding.edtCamp.text ?: ""
        binding.btnView.setOnClickListener {
            if (!checkIfFieldsAreEmpty() && textView.isNotEmpty()) {
                val action = ScreenOneDirections.actionScreenOneToScreenTwo(textView.toString())
                findNavController().navigate(action)
            }
        }
    }

    private fun checkIfFieldsAreEmpty(): Boolean {
        var empty = false
        binding.apply {
            if (binding.edtCamp.text.toString().isEmpty()) {
                binding.txtField.error = "Preencha o campo"
                empty = true
            }
        }
        return empty
    }
}