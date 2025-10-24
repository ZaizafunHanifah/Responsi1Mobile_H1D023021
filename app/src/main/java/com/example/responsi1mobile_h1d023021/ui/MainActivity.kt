package com.example.responsi1mobile_h1d023021.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.responsi1mobile_h1d023021.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up menu items
        setupMenuItem(R.id.layout_history, "Club History", R.drawable.rayo_vallecano_logo)
        setupMenuItem(R.id.layout_coach, "Head Coach", R.drawable.rayo_vallecano_logo)
        setupMenuItem(R.id.layout_squad, "Team Squad", R.drawable.rayo_vallecano_logo)

        // Debug logging
        println("Menu items setup completed")

        // Set up click listeners for menu items
        findViewById<androidx.cardview.widget.CardView>(R.id.layout_history).setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }

        findViewById<androidx.cardview.widget.CardView>(R.id.layout_coach).setOnClickListener {
            startActivity(Intent(this, CoachActivity::class.java))
        }

        findViewById<androidx.cardview.widget.CardView>(R.id.layout_squad).setOnClickListener {
            startActivity(Intent(this, SquadActivity::class.java))
        }

    }

    private fun setupMenuItem(menuId: Int, title: String, iconResId: Int) {
        val menuView = findViewById<androidx.cardview.widget.CardView>(menuId)
        if (menuView != null) {
            val iconView = menuView.findViewById<ImageView>(R.id.img_icon)
            val titleView = menuView.findViewById<TextView>(R.id.tv_layout)

            iconView?.setImageResource(iconResId)
            titleView?.text = title
        }
    }
}