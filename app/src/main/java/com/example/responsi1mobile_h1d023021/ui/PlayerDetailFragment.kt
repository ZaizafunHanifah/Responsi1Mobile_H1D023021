package com.example.responsi1mobile_h1d023021.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.responsi1mobile_h1d023021.R

class PlayerDetailFragment : Fragment() {

    private var playerName: String? = null
    private var playerPosition: String? = null
    private var playerBirth: String? = null
    private var playerNationality: String? = null

    companion object {
        private const val ARG_NAME = "name"
        private const val ARG_POSITION = "position"
        private const val ARG_BIRTH = "birth"
        private const val ARG_NATIONALITY = "nationality"

        fun newInstance(name: String, position: String, birth: String, nationality: String): PlayerDetailFragment {
            val fragment = PlayerDetailFragment()
            val args = Bundle()
            args.putString(ARG_NAME, name)
            args.putString(ARG_POSITION, position)
            args.putString(ARG_BIRTH, birth)
            args.putString(ARG_NATIONALITY, nationality)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            playerName = it.getString(ARG_NAME)
            playerPosition = it.getString(ARG_POSITION)
            playerBirth = it.getString(ARG_BIRTH)
            playerNationality = it.getString(ARG_NATIONALITY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_player_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.tvDetailName).text = playerName ?: "Unknown"
        view.findViewById<TextView>(R.id.tvDetailBirth).text = playerBirth ?: "Unknown"
        view.findViewById<TextView>(R.id.tvDetailNationality).text = playerNationality ?: "Unknown"
        view.findViewById<TextView>(R.id.tvDetailPosition).text = playerPosition ?: "Unknown"
    }
}