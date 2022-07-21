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
        var num1 = inIntent.getIntExtra("Num1", 0)
        var num2 = inIntent.getIntExtra("Num2", 0)
        var calc = inIntent.getStringExtra("Calculate")

        var btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            when (calc) {
                "add" -> {
                    var resultValue = num1 + num2
                    var outIntent = Intent(applicationContext, MainActivity::class.java)
                    outIntent.putExtra("Result", resultValue)
                    setResult(Activity.RESULT_OK, outIntent)
                    finish()
                }
                "sub" -> {
                    var resultValue = num1 - num2
                    var outIntent = Intent(applicationContext, MainActivity::class.java)
                    outIntent.putExtra("Result", resultValue)
                    setResult(Activity.RESULT_OK, outIntent)
                    finish()
                }
                "mul" -> {
                    var resultValue = num1 * num2
                    var outIntent = Intent(applicationContext, MainActivity::class.java)
                    outIntent.putExtra("Result", resultValue)
                    setResult(Activity.RESULT_OK, outIntent)
                    finish()
                }
                "div" -> {
                    var resultValue = num1 / num2
                    var outIntent = Intent(applicationContext, MainActivity::class.java)
                    outIntent.putExtra("Result", resultValue)
                    setResult(Activity.RESULT_OK, outIntent)
                    finish()
                }
                "rem" -> {
                    var resultValue = num1 % num2
                    var outIntent = Intent(applicationContext, MainActivity::class.java)
                    outIntent.putExtra("Result", resultValue)
                    setResult(Activity.RESULT_OK, outIntent)
                    finish()
                }
            }
        }
    }
}