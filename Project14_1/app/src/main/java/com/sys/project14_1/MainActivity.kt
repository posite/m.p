package com.sys.project14_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var soundIntent: Intent
    lateinit var btnStart: Button
    lateinit var btnStop: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title="서비스 테스트 예제"
        soundIntent = Intent(this, MusicClass::class.java)
        btnStart = findViewById<Button>(R.id.btnStart)
        btnStop = findViewById<Button>(R.id.btnStop)

        btnStart.setOnClickListener {
            startService(soundIntent)
            android.util.Log.i("서비스 테스트", "startService()")
        }

        btnStop.setOnClickListener {
            stopService(soundIntent)
            android.util.Log.i("서비스 테스트", "stopService()")
        }
    }
}