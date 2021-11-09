package com.application.mentalhealth.SimpleViews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.application.mentalhealth.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
    }
}