package com.example.chaewonnolja.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.chaewonnolja.R
import com.example.chaewonnolja.databinding.ActivityMainBinding
import com.example.chaewonnolja.fragment.ReserveFragment
import com.example.chaewonnolja.fragment.RestFragment
import com.example.chaewonnolja.fragment.SearchFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRest.setOnClickListener {
            // view 에 불러오는 fragment 설정
            supportFragmentManager.beginTransaction()
                .replace(R.id.view, RestFragment())
                .commit()

        }

        binding.btnSearch.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.view, SearchFragment())
                .commit()
        }

        binding.btnReserve.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.view, ReserveFragment())
                .commit()
        }

    }
}