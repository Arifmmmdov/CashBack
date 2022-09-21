package com.example.cashback

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cashback.databinding.ActivityMainBinding
import com.example.cashback.fragment.PartnersFragment

class MainActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setFragmentView()
    }

    private fun setFragmentView() {
        supportFragmentManager.beginTransaction()
            .replace(binding.partnersActivityContainerView.id,PartnersFragment())
            .commit()
    }
}