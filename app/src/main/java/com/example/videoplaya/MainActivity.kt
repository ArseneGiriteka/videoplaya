package com.example.videoplaya

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import android.widget.MediaController

class MainActivity : AppCompatActivity() {

    // Declare the VideoView and Buttons
    private lateinit var videoView: VideoView
    private lateinit var btnPlay: Button
    private lateinit var btnPause: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the VideoView and Buttons
        videoView = findViewById(R.id.videoView)
        btnPlay = findViewById(R.id.btnPlay)
        btnPause = findViewById(R.id.btnPause)

        // Specify the video path (can be a URI or a local resource)
        val videoUri: Uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.sample_video)


        // Set the video URI to the VideoView
        videoView.setVideoURI(videoUri)

        // Set up media controls for the VideoView
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        // Play the video when the Play button is clicked
        btnPlay.setOnClickListener {
            videoView.start()
        }

        // Pause the video when the Pause button is clicked
        btnPause.setOnClickListener {
            videoView.pause()
            println(R.string.app_name)
        }
    }
}
