package com.example.chaewonnolja.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chaewonnolja.R
import com.example.chaewonnolja.databinding.ActivityMainBinding
import com.example.chaewonnolja.view.fragment.ReserveFragment
import com.example.chaewonnolja.view.fragment.RestFragment
import com.example.chaewonnolja.view.fragment.SearchFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val trans =supportFragmentManager.beginTransaction()

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //하단 바 네비게이션
        bottomNavigation()

        //메인 화면 초기화
        trans.replace(R.id.view, RestFragment())
        trans.commit()

        //유저이름
    }


    private fun bottomNavigation(){
        binding.btnRest.setOnClickListener {
            // view 에 불러오는 fragment 설정
            trans.replace(R.id.view, RestFragment())
            trans.commit()

        }

        binding.btnSearch.setOnClickListener {
            trans.replace(R.id.view, SearchFragment())
            trans.commit()
        }

        binding.btnReserve.setOnClickListener {
            trans.replace(R.id.view, ReserveFragment())
            trans.commit()
        }
    }
}