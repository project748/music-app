package com.example.musicapp

import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    private val songUrl = "https://www.dropbox.com/scl/fi/dgav25jp9t5r2jvnl868f/Deva-Deva-Brahmastra-128-Kbps.mp3?rlkey=gho5nolgq7t6cr0d2fg2vj068&st=l7j5dwcb&dl=1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playButton: Button = findViewById(R.id.playButton)

        playButton.setOnClickListener {
            val intent = Intent(this, MusicService::class.java)
            intent.putExtra("songUrl", songUrl)
            startService(intent)
        }
    }
}
