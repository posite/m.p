package com.example.project6_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnStart : Button
        var btnStop : Button
        var vFlipper : ViewFlipper

        btnStart = findViewById<Button>(R.id.btnStart1)
        btnStop = findViewById<Button>(R.id.btnStop1)
        vFlipper = findViewById<ViewFlipper>(R.id.viewFlipper1)
        vFlipper.flipInterval=2000

        btnStart.setOnClickListener {
            vFlipper.startFlipping()
        }

        btnStop.setOnClickListener {
            vFlipper.stopFlipping()
        }
    }
}
