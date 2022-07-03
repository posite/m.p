package com.sys.project10_2_2

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        title = "Second 액티비티"

        var inIntent = intent
        var hapValue = inIntent.getIntExtra("Num1", 0) + inIntent.getIntExtra("Num2", 0)

        var btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            var outIntent = Intent(applicationContext, MainActivity::class.java)
            outIntent.putExtra("Hap", hapValue)
            setResult(Activity.RESULT_OK, outIntent)
            finish()
        }
    }
}