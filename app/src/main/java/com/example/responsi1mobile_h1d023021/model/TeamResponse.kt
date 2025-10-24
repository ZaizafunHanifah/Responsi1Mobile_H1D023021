package com.example.responsi1mobile_h1d023021.model

import com.example.responsi1mobile_h1d023021.model.Coach

class TeamResponse {
    data class TeamResponse(
        val name: String,
        val crest: String,
        val venue: String,
        val area: Area,
        val coach: Coach.Coach,
        val squad: List<Player>
    )

    data class Area(val name: String)

}