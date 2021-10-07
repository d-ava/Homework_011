package com.example.homework_011

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework_011.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {


    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.hamburger.alpha = 0f
        binding.hamburger.animate().setDuration(1500).alpha(1f).withEndAction {
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }


    }
}