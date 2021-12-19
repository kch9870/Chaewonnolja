package com.example.chaewonnolja.view.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.android.volley.Request
import com.android.volley.Request.Method.GET
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.chaewonnolja.R
import com.example.chaewonnolja.model.LoginModel
import com.example.chaewonnolja.model.NoljaClient
import com.example.chaewonnolja.model.StringResult
import com.example.chaewonnolja.model.service.HttpApi
import com.example.chaewonnolja.model.service.VolleyService
import com.example.chaewonnolja.view.`object`.MySharedPreferences
import com.example.chaewonnolja.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.POST
import java.lang.reflect.Method

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




//        val noljaClient = NoljaClient()
//
//        noljaClient.service.getRequest()?.enqueue(object : Callback<List<StringResult>> {
//
//            override fun onFailure(call: Call<List<StringResult>>, t: Throwable) {
//                Log.e("Retrofit", t.toString())
//                Log.d("Retrofit", "fail")
//            }
//
//            override fun onResponse(call: Call<List<StringResult>>, response: Response<List<StringResult>>) {
//                // onResponse가 무조건 성공 응답이 아니기 때문에 inSuccessful() 메소드를 통해 확인 필요
//                if (response.isSuccessful()) {
//                    Log.e("Retrofit", response.body().toString())
//                    }
//                }
//        })

        //val repos: Call<List<StringResult>> = NoljaService.getRequest()


//        val data = LoginModel("kim","1234")
//        // Enqueue로 비동기 통신 실행
//        noljaClient.service?.postRequest(data)?.enqueue(object : Callback<PostResult> {
//
//            // 통신 실패 시 콜백
//            override fun onFailure(call: Call<PostResult>, t: Throwable) {
//                Log.e("Retrofit", t.toString())
//                Log.d("Retrofit", "fail")
//            }
//            // 통신 성공 시 콜백
//            override fun onResponse(call: Call<PostResult>, response: Response<PostResult>) {
//                Log.d("Retrofit", response.body().toString())
//            }
//        })


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