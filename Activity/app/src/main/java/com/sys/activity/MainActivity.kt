package com.sys.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnNewActivity = findViewById<Button>(R.id.btn1)
        var rSecond = findViewById<RadioButton>(R.id.second)
        var rThird = findViewById<RadioButton>(R.id.third)

        btnNewActivity.setOnClickListener {
            if(rSecond.isChecked){
                var intent = Intent(applicationContext,SecondActivity::class.java)
                startActivity(intent)
            }
            if(rThird.isChecked){
                var intent = Intent(applicationContext,ThirdActivity::class.java)
                startActivity(intent)
            }

        }
    }
}