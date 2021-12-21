package com.example.chaewonnolja.view.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.chaewonnolja.R
import com.example.chaewonnolja.model.JoinResult
import com.example.chaewonnolja.model.LoginResult
import com.example.chaewonnolja.model.NoljaClient
import com.example.chaewonnolja.view.`object`.MySharedPreferences
import com.example.chaewonnolja.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class LoginActivity :AppCompatActivity(){

    //private lateinit var model: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val LoginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        btnLogin.setOnClickListener {
            LoginViewModel.SharedPreferencesCheck(
                MySharedPreferences.getUserId(this), MySharedPreferences.getUserPass(this),
                editId.text.toString(), editPassword.text.toString()
            )


            //로그인 Retrofit 통신
            //val data=LoginModel(editId.toString(),editPassword.toString())

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
            })

        }
        btnSignup.setOnClickListener{
            val intent = Intent(this,SignuUpActivity::class.java)
            startActivity(intent)
        }

        /*ViewModel*/

        LoginViewModel.loginchecktrue.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(this, "아이디와 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show()
            }
        })
        LoginViewModel.logincheckfalse.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                MySharedPreferences.setUserId(this, editId.text.toString())
                MySharedPreferences.setUserPass(this, editPassword.text.toString())
                Toast.makeText(this, "${MySharedPreferences.getUserId(this)}님 로그인 되었습니다.", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
        LoginViewModel.sharedpreferencesfalse.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(this, "${MySharedPreferences.getUserId(this)}님 자동 로그인 되었습니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        })


    }

}