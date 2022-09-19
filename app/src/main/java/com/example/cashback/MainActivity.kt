package com.example.cashback

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cashback.databinding.ActivityMainBinding
import com.example.cashback.fragment.CashBackDetailsFragment
import com.example.cashback.fragment.PartnersFragment
import com.example.e24_mobile_new.fragment.FilterFragment

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
            .replace(binding.containerViewPartnersFragment.id,FilterFragment())
            .commit()
    }
}