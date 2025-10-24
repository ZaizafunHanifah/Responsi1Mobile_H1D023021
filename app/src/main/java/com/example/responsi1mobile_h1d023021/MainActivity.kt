package com.example.responsi1mobile_h1d023021

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.responsi1mobile_h1d023021.ui.CoachActivity
import com.example.responsi1mobile_h1d023021.ui.HistoryActivity
import com.example.responsi1mobile_h1d023021.ui.SquadActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val mainView = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.main)
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }

        // Set up menu items
        setupMenuItem(R.id.layout_history, "Club History", R.drawable.history)
        setupMenuItem(R.id.layout_coach, "Head Coach", R.drawable.coach)
        setupMenuItem(R.id.layout_squad, "Team Squad", R.drawable.team)

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