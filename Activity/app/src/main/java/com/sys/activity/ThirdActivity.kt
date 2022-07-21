package com.sys.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        title = "Third"
        var button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            finish()
        }
    }
}