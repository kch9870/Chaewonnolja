package com.example.chaewonnolja.view.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.chaewonnolja.R
import com.example.chaewonnolja.model.JoinModel
import com.example.chaewonnolja.model.JoinResult
import com.example.chaewonnolja.model.NoljaClient
import com.example.chaewonnolja.view.`object`.MySharedPreferences
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_signup.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignuUpActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

//        var id=joinId.text.toString()
//        var password=passWord.text.toString()
//        var name=userName.text.toString()

        btnJoin.setOnClickListener{
            //Retrofit 통신
            val noljaClient = NoljaClient()
            noljaClient.service?.joinRequest(joinId.text.toString(),joinpassWord.text.toString(),joinnickName.text.toString())?.enqueue(object: Callback<JoinResult>{
                override fun onFailure(call: Call<JoinResult>, t: Throwable) {
                    Log.e("Retrofit", t.toString())
                    Log.d("Retrofit", "fail")
                }
                override fun onResponse(call: Call<JoinResult>, response: Response<JoinResult>) {
                    if (response.isSuccessful()) {
                        Log.d("Retrofit", response.body().toString())
                        Log.d("Data",  response.body()?.nickName.toString())
                    }
                }
            })
        }
    }
}