package com.example.chaewonnolja.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.chaewonnolja.R
import com.example.chaewonnolja.databinding.ActivityMainBinding
import com.example.chaewonnolja.databinding.ActivityReserveInfoBinding
import com.example.chaewonnolja.databinding.FragmentRestBinding
import com.example.chaewonnolja.fragment.ReserveFragment
import com.example.chaewonnolja.fragment.RestFragment
import com.example.chaewonnolja.fragment.SearchFragment

class ReserveInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val binding2 = ActivityReserveInfoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding2.root)

    }


}