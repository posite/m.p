package com.sys.p5_1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        val baseLayout = LinearLayout(this)
        baseLayout.orientation = LinearLayout.VERTICAL
        setContentView(baseLayout, params)

        val edit = EditText(this)
        edit.hint = "입력하세요"
        baseLayout.addView(edit)

        val btn = Button(this)
        btn.text = "버튼입니다"
        btn.setBackgroundColor(Color.YELLOW)
        baseLayout.addView(btn)

        val result = TextView(this)
        result.setTextColor(Color.MAGENTA)
        baseLayout.addView(result)

        btn.setOnClickListener {
            result.text = edit.text.toString()
        }
    }
}