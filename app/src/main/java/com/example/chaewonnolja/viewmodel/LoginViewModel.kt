package com.example.chaewonnolja.viewmodel

import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chaewonnolja.model.NoljaClient
import com.example.chaewonnolja.view.`object`.MySharedPreferences
import com.example.chaewonnolja.view.activity.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class LoginViewModel:ViewModel() {

    private val _loginCheckTrue = MutableLiveData<Event<Boolean>>()
    private val _loginCheckFalse = MutableLiveData<Event<Boolean>>()
    private val _sharedPreferencesFalse = MutableLiveData<Event<Boolean>>()

    val loginCheckTrue: LiveData<Event<Boolean>> = _loginCheckTrue
    val loginCheckFalse: LiveData<Event<Boolean>> = _loginCheckFalse
    val sharedPreferencesFalse: LiveData<Event<Boolean>> = _sharedPreferencesFalse

    //로그인
    fun LoginCheck(editId: String, editPassword: String){
        if(editId.isNullOrBlank() || editPassword.isNullOrBlank()) {
            _loginCheckTrue.value = Event(true)
        }
        else {
            _loginCheckFalse.value = Event(true)
        }
    }

    //자동로그인
    fun SharedPreferencesCheck(getId: String, getPassword: String,editId: String,editPassword: String){
        if(getId.isNullOrBlank() || getPassword.isNullOrBlank()) {
            //로그인 확인
            LoginCheck(editId,editPassword)
        }
        else { // SharedPreferences 안에 값이 저장되어 있을 때 -> MainActivity로 이동
            _sharedPreferencesFalse.value=Event(true)
        }
    }
}