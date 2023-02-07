package com.example.chaewonnolja.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chaewonnolja.databinding.ActivityReserveInfoBinding

class ReserveInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val binding2 = ActivityReserveInfoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding2.root)
    }


}