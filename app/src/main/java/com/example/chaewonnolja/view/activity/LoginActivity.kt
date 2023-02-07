package com.example.chaewonnolja.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chaewonnolja.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity :AppCompatActivity(){

    //private lateinit var model: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {

            /**
             * 로그인 Retrofit 통신
             */
            /*
            val noljaClient = NoljaClient()
            noljaClient.loginService?.loginRequest(editId.text.toString(),editPassword.text.toString())?.enqueue(object: retrofit2.Callback<LoginResult> {
                override fun onFailure(call: Call<LoginResult>, t: Throwable) {
                    Log.e("Retrofit", t.toString())
                    Log.d("Retrofit", "fail")
                }
                override fun onResponse(call: Call<LoginResult>, response: Response<LoginResult>) {
                    if (response.isSuccessful()) {
                        Log.d("Retrofit", response.body().toString())
                    }
                }
            })*/

        }
        btnSignup.setOnClickListener{
            val intent = Intent(this,SignuUpActivity::class.java)
            startActivity(intent)
        }

        /*ViewModel*/

    }

}