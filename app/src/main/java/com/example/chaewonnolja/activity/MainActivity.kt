package com.example.chaewonnolja.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.chaewonnolja.R
import com.example.chaewonnolja.`object`.MySharedPreferences
import com.example.chaewonnolja.databinding.ActivityMainBinding
import com.example.chaewonnolja.databinding.FragmentRestBinding
import com.example.chaewonnolja.fragment.ReserveFragment
import com.example.chaewonnolja.fragment.RestFragment
import com.example.chaewonnolja.fragment.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //하단 바 네비게이션
        bottomNavigation()

        //메인 화면 초기화
        supportFragmentManager.beginTransaction()
            .replace(R.id.view, RestFragment())
            .commit()

        //유저이름
        userID.setText("ID : " + MySharedPreferences.getUserId(this))

    }

    private fun bottomNavigation(){
        binding.btnRest.setOnClickListener {
            // view 에 불러오는 fragment 설정
            supportFragmentManager.beginTransaction()
                .replace(R.id.view, RestFragment())
                .commit()

        }

        binding.btnSearch.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.view, SearchFragment())
                .commit()
        }

        binding.btnReserve.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.view, ReserveFragment())
                .commit()
        }
    }
}