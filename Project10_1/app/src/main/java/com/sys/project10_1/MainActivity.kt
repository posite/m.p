package com.sys.project10_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {

    lateinit var rdoGroup:RadioGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rdoGroup=findViewById<RadioGroup>(R.id.rdoGroup)
        var btnNewActivity = findViewById<Button>(R.id.btnNewActivity)
        btnNewActivity.setOnClickListener {

            if(rdoGroup.checkedRadioButtonId==R.id.secondB){
                var intent = Intent(applicationContext, SecondActivity::class.java)
                startActivity(intent)
            }else if(rdoGroup.checkedRadioButtonId==R.id.thirdB){
                var intent = Intent(applicationContext, ThirdActivity::class.java)
                startActivity(intent)
            }

        }
    }
}