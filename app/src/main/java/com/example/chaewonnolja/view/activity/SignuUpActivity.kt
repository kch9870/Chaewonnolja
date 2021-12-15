package com.example.chaewonnolja.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.chaewonnolja.R
import com.example.chaewonnolja.model.JoinModel
import com.example.chaewonnolja.view.`object`.MySharedPreferences
import kotlinx.android.synthetic.main.activity_signup.*

class SignuUpActivity: AppCompatActivity(){

    private var name: String? = ""
    private var id: String? = ""
    private var password: String? = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        name=userName.text.toString()
        id=joinId.text.toString()
        password=passWord.text.toString()


    }
}