package com.example.responsi1mobile_h1d023021.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentTransaction
import com.example.responsi1mobile_h1d023021.R

class SquadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_squad)

        supportActionBar?.title = "Squad"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        displaySamplePlayers()
    }

    private fun displaySamplePlayers() {
        val container = findViewById<LinearLayout>(R.id.playersContainer)
        val detailContainer = findViewById<android.widget.FrameLayout>(R.id.playerDetailContainer)
        val inflater = LayoutInflater.from(this)

        // Sample players data
        data class PlayerData(val name: String, val position: String, val birthDate: String, val nationality: String)

        val samplePlayers = listOf(
            PlayerData("Augusto Batalla", "Goalkeeper", "1996-04-30", "Argentina"),
            PlayerData("Dani Cárdenas", "Goalkeeper", "1997-03-28", "Spain"),
            PlayerData("Alfonso Espino", "Defender", "1992-01-05", "Uruguay"),
            PlayerData("Florian Lejeune", "Defender", "1991-05-20", "France"),
            PlayerData("Gerard Gumbau", "Midfielder", "1994-12-18", "Spain"),
            PlayerData("Óscar Trejo", "Midfielder", "1988-04-26", "Argentina"),
            PlayerData("Isi Palazón", "Forward", "1994-12-27", "Spain"),
            PlayerData("Sergio Camello", "Forward", "2001-02-10", "Spain")
        )

        for (player in samplePlayers) {
            val playerView = inflater.inflate(R.layout.player_card, container, false)
            val card = playerView.findViewById<CardView>(R.id.playerCard)
            val nameText = playerView.findViewById<TextView>(R.id.tvPlayerName)

            nameText.text = player.name
            val nationalityText = playerView.findViewById<TextView>(R.id.tvPlayerNationality)
            nationalityText.text = player.nationality

            // Set card color based on position
            val color = getPositionColor(player.position)
            card.setCardBackgroundColor(color)

            // Click listener to show player details in fragment
            card.setOnClickListener {
                showPlayerDetail(player.name, player.position, player.birthDate, player.nationality)
            }

            container.addView(playerView)
        }
    }

    private fun showPlayerDetail(name: String, position: String, birthDate: String, nationality: String) {
        val detailContainer = findViewById<android.widget.FrameLayout>(R.id.playerDetailContainer)
        detailContainer.visibility = View.VISIBLE

        val fragment = PlayerDetailFragment.newInstance(name, position, birthDate, nationality)
        supportFragmentManager.beginTransaction()
            .replace(R.id.playerDetailContainer, fragment)
            .commit()

        // Click listener to hide the detail when clicking outside
        detailContainer.setOnClickListener {
            hidePlayerDetail()
        }
    }

    private fun hidePlayerDetail() {
        val detailContainer = findViewById<android.widget.FrameLayout>(R.id.playerDetailContainer)
        detailContainer.visibility = View.GONE

        // Remove the fragment
        val fragment = supportFragmentManager.findFragmentById(R.id.playerDetailContainer)
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .remove(fragment)
                .commit()
        }
    }

    private fun getPositionColor(position: String?): Int {
        return when (position?.lowercase()) {
            "goalkeeper" -> Color.YELLOW
            "defender", "centre-back", "right-back", "left-back", "defence" -> Color.BLUE
            "midfielder", "central midfielder", "attacking midfielder", "defensive midfielder", "left midfielder", "right midfielder", "midfield" -> Color.GREEN
            "forward", "centre-forward", "left winger", "right winger", "offence" -> Color.RED
            "coach" -> Color.MAGENTA
            else -> Color.GRAY
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}