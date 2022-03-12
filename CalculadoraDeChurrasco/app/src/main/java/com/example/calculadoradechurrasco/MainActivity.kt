package com.example.calculadoradechurrasco

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR

        supportFragmentManager.beginTransaction()
            .add(R.id.mainContainer, FormFragment(), "FormFragment").commit();
    }
}