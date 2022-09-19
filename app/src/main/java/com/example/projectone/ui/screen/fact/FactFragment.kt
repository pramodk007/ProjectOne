package com.example.projectone.ui.screen.fact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.projectone.R
import com.example.projectone.core.Resource
import com.example.projectone.core.utils.viewBinding
import com.example.projectone.databinding.FragmentFactBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FactFragment : Fragment(R.layout.fragment_fact) {
    private val binding by viewBinding(FragmentFactBinding::bind)
    private val viewModel: FactViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        onClick()
    }

    private fun onClick() {
        binding.btnGenerate.setOnClickListener {
            observe()
        }
    }


    private fun observe() {
        viewModel.factLiveData.observe(viewLifecycleOwner) { dataResource ->
            when (dataResource.status) {
                Resource.Status.SUCCESS -> {
                    var facts = dataResource.data
                    binding.tvFact.text = facts!!.fact
                    Toast.makeText(context, "SUCCESS :$facts", Toast.LENGTH_SHORT).show()
                }
                Resource.Status.ERROR -> {
                    Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show()
                }
                Resource.Status.LOADING -> {
                    Toast.makeText(context, "Loading", Toast.LENGTH_SHORT).show()
                }
                Resource.Status.ERROR_LOGICAL -> {
                    Toast.makeText(context, "ERROR_LOGICAL", Toast.LENGTH_SHORT).show()
                }
            }
        }
        viewModel.getFacts()
    }

}