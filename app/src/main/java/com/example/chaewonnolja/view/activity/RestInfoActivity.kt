package com.example.chaewonnolja.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chaewonnolja.databinding.ActivityRestinfoBinding

class RestInfoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val binding2 = ActivityRestinfoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding2.root)

    }
}