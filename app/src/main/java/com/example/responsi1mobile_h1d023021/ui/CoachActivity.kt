package com.example.responsi1mobile_h1d023021.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.responsi1mobile_h1d023021.R

class CoachActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coach)

        supportActionBar?.title = "Head Coach"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        displayDefaultCoachData()
    }

    private fun displayDefaultCoachData() {
        val imgCoach = findViewById<ImageView>(R.id.imgCoach)
        val tvCoachName = findViewById<TextView>(R.id.tvCoachName)
        val tvCoachBirth = findViewById<TextView>(R.id.tvCoachBirth)
        val tvCoachNationality = findViewById<TextView>(R.id.tvCoachNationality)

        imgCoach.setImageResource(R.drawable.head_coach)

        tvCoachName.text = "Iñigo Pérez"
        tvCoachBirth.text = "1988-01-18"
        tvCoachNationality.text = "Spain"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}