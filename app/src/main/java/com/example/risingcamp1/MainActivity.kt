package com.example.risingcamp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

private lateinit var HomeFragment: homeFragment
private lateinit var SearchFragment: searchFragment
private lateinit var MyProfileFragment: myProfileFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView) // bottomNavigationView 객체를 가져옴
        
        supportFragmentManager.beginTransaction().add(R.id.frameLayout, homeFragment()).commitAllowingStateLoss() // frameLayout에 homeFragment를 추가함
        bottomNavigationView.setOnItemSelectedListener { // bottomNavigationView의 item 선택 리스너
            when(it.itemId){ // item의 id에서
                R.id.menuHome -> { // menuHome을 선택하면
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout, homeFragment()).commitAllowingStateLoss()
                    // frameLayout을 homeFragment로 대체
                    true // 성공하면 true 리턴
                    }
                R.id.menuSearch -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout, searchFragment()).commitAllowingStateLoss()
                    true
                }
                R.id.menuMyProfile -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout, myProfileFragment()).commitAllowingStateLoss()
                    true
                }
                else -> false
            }
        }
    }
}