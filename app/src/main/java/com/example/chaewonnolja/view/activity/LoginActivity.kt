package com.example.chaewonnolja.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.chaewonnolja.R
import com.example.chaewonnolja.view.`object`.MySharedPreferences
import com.example.chaewonnolja.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity :AppCompatActivity(){

    private lateinit var model: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val LoginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        btnLogin.setOnClickListener {
            LoginViewModel.SharedPreferencesCheck(
                MySharedPreferences.getUserId(this), MySharedPreferences.getUserPass(this),
                editId.text.toString(), editPassword.text.toString()
            )
        }

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

        val call = api.getMovieListRetrofit(param) // (2) REST API의 요청
        val response = call.execute() // (3) 요청의 실행

        if (response.isSuccessful) {
            val movieList = response.body()?.results?.map { // (4) 응답받은 데이터에서 results읽기
                MovieItem( // (5) 각각의 목록 요소를 데이터 클래스로 초기화
                    it.vote_count,
                    it.vote_average,
                    it.title,
                    it.release_date,
                    it.poster_path,
                    it.overview
                )
            }


    }



    /*fun SharedPreferencesEvent(){
        if(MySharedPreferences.getUserId(this).isNullOrBlank()
            || MySharedPreferences.getUserPass(this).isNullOrBlank()) {
            //로그인 확인
        }
        else { // SharedPreferences 안에 값이 저장되어 있을 때 -> MainActivity로 이동
            Toast.makeText(this, "${MySharedPreferences.getUserId(this)}님 자동 로그인 되었습니다.", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }*/

    /*fun Login() {

        btnLogin.setOnClickListener {

            if(editId.text.isNullOrBlank() || editPassword.text.isNullOrBlank()) {
                Toast.makeText(this, "아이디와 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show()
            }
            else {
                MySharedPreferences.setUserId(this, editId.text.toString())
                MySharedPreferences.setUserPass(this, editPassword.text.toString())
                Toast.makeText(this, "${MySharedPreferences.getUserId(this)}님 로그인 되었습니다.", Toast.LENGTH_SHORT).show()
                    var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }*/
}