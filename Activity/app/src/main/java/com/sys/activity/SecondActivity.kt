package com.sys.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        title= "Second"
        var button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            finish()
        }
    }
}