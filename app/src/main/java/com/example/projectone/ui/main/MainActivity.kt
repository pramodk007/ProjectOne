package com.example.projectone.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectone.R
import com.example.projectone.core.utils.viewBinding
import com.example.projectone.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}