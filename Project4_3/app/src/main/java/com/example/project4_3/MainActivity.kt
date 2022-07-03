package com.example.project4_3

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    lateinit var editText:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title="연습문제 3"
        editText=findViewById<EditText>(R.id.Edit1)
        editText.setOnKeyListener{ view: View, i: Int, keyEvent: KeyEvent ->

            if(KeyEvent.ACTION_UP==keyEvent.action||KeyEvent.ACTION_DOWN==keyEvent.action){
                Toast.makeText(applicationContext,editText.text.toString(),Toast.LENGTH_SHORT).show()
                true
            }else{
                false
            }
            false
        }

    }
}