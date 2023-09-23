package com.example.mvdesafioa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mvdesafioa.databinding.FragmentScreenTwoBinding

class ScreenTwo : Fragment() {

    private var _binding: FragmentScreenTwoBinding? = null
    private val binding get() = _binding!!

    private val args: ScreenTwoArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentScreenTwoBinding.inflate(
        inflater,
        container,
        false
    ).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtCamp.text = args.texto
        setupButton()
    }

    private fun setupButton() {
        binding.btnView.setOnClickListener {
            findNavController().navigate(R.id.action_screenTwo_to_screenOne)
        }
    }
}