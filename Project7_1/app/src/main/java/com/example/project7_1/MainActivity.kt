package com.example.project7_1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var ed1 :EditText
    lateinit var img1 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "제주도"

        ed1=findViewById<EditText>(R.id.ed1)
        img1=findViewById<ImageView>(R.id.img1)
    }

    override fun onCreateOptionsMenu(menu: Menu?) : Boolean {
        super.onCreateOptionsMenu(menu)
        var mInflater = menuInflater
        mInflater.inflate(R.menu.menu0, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) : Boolean {
        when (item.itemId) {
            R.id.itemRotate -> {
                img1.rotation=ed1.text.toString().toFloat()
                return true
            }
            R.id.item1 -> {
                img1.setImageResource(R.drawable.jeju2)
                return true
            }
            R.id.item2 -> {
                img1.setImageResource(R.drawable.jeju4)
                return true
            }
            R.id.item3 -> {
                img1.setImageResource(R.drawable.jeju6)
                return true
            }

        }
        return false
    }
}