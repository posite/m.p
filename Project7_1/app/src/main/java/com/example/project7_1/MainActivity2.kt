package com.example.project7_1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout

class MainActivity2 : AppCompatActivity() {
    lateinit var baseLayout : LinearLayout
    lateinit var button1 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        title = "배경색 바꾸기"
        baseLayout = findViewById(R.id.baseLayout2)
        button1 = findViewById(R.id.button2)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        var mInflater = menuInflater
        mInflater.inflate(R.menu.menu1, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var count1 : Int = 0
        var count2 : Int = 0
        when (item.itemId) {
            R.id.red -> {
                baseLayout.setBackgroundColor(Color.RED)
                return true
            }
            R.id.green -> {
                baseLayout.setBackgroundColor(Color.GREEN)
                return true
            }
            R.id.blue -> {
                baseLayout.setBackgroundColor(Color.BLUE)
                return true
            }
            R.id.rotation -> {
                count1 += 1
                button1.rotation = 45f*count1
                return true
            }
            R.id.size -> {
                count2 += 1
                button1.scaleX = 2f*count2
                return true
            }

        }
        return true
    }
}