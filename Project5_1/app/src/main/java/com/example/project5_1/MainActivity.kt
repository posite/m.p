package com.example.project5_1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        var params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT)
        var baseLayout = LinearLayout(this)
        baseLayout.orientation = LinearLayout.VERTICAL

        setContentView(baseLayout, params)

        var eText= EditText(this)
        baseLayout.addView(eText)
        var btn = Button(this)
        btn.text = "버튼입니다"
        btn.setBackgroundColor(Color.YELLOW)
        baseLayout.addView(btn)
        var txt = TextView(this)
        txt.text=""
        txt.setTextColor(Color.MAGENTA)
        baseLayout.addView(txt)
        btn.setOnClickListener {
            txt.text=eText.text.toString()
        }
    }
}