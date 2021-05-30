package com.example.dictionnaire

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val seances = ArrayList<data>()
        seances.add(data("word","meaning",R.raw.sound))
        seances.add(data("word","meaning",R.raw.sound))
        seances.add(data("word","meaning",R.raw.sound))
        seances.add(data("word","meaning",R.raw.sound))
        myrecview.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val adptr = CustomAdapter(seances)
        myrecview.adapter = adptr


        btn.setOnClickListener {
            var intnt = Intent(this, detailsActivity::class.java)
            startActivity(intnt)





        }

    }
}
