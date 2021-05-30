package com.example.dictionnaire

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.activity_main.*

class detailsActivity : AppCompatActivity() {

    private var mp: MediaPlayer? = null
    private var currentword : MutableList<Int> = mutableListOf(R.raw.sound)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)


        controlSound(currentword[0])


    }


    private fun controlSound(id: Int){
        b_lire.setOnClickListener {
            if(mp == null){
                mp = MediaPlayer.create(this,id)
                Log.d("MainActivity", "ID: ${mp!!.audioSessionId}")

            }
            mp?.start()
            Log.d("MainActivity", "Duration: ${mp!!.duration/1000} seconds")

        }
        b_pause.setOnClickListener {
            if (mp !== null) mp?.pause()
            Log.d("MainActivity", "Paused at: ${mp!!.currentPosition/1000} seconds")
        }
        b_stop.setOnClickListener {
            if(mp !== null){
                mp?.stop()
                mp?.reset()
                mp?.release()
                mp = null

            }
        }


    }


}
