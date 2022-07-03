package com.example.project4_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var text1: TextView
    lateinit var text2: TextView
    lateinit var switchAgree: Switch
    lateinit var rGroup1:RadioGroup
    lateinit var rdoOreo:RadioButton
    lateinit var rdoPi:RadioButton
    lateinit var rdoQ:RadioButton
    lateinit var choice:Button
    lateinit var finish:Button
    lateinit var reset:Button
    lateinit var imgAndroid:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title="안드로이드 사진 보기"
        text1=findViewById<TextView>(R.id.Text1)
        text2=findViewById<TextView>(R.id.Text2)
        switchAgree=findViewById<Switch>(R.id.switch1)
        rGroup1=findViewById<RadioGroup>(R.id.Rgroup1)
        rdoOreo=findViewById<RadioButton>(R.id.RdoOreo)
        rdoPi=findViewById<RadioButton>(R.id.RdoPi)
        rdoQ=findViewById<RadioButton>(R.id.RdoQ)
        choice=findViewById<Button>(R.id.Choice)
        finish=findViewById<Button>(R.id.Finish)
        reset=findViewById<Button>(R.id.Reset)
        imgAndroid=findViewById<ImageView>(R.id.ImgAndroid)
        switchAgree.setOnCheckedChangeListener { compoundButton, b ->
            if(switchAgree.isChecked==true){
                text2.visibility=android.view.View.VISIBLE
                rGroup1.visibility=android.view.View.VISIBLE
                rdoOreo.visibility=android.view.View.VISIBLE
                rdoPi.visibility=android.view.View.VISIBLE
                rdoQ.visibility=android.view.View.VISIBLE
                choice.visibility=android.view.View.VISIBLE
            }else{
                text2.visibility=android.view.View.INVISIBLE
                rGroup1.visibility=android.view.View.INVISIBLE
                rdoOreo.visibility=android.view.View.INVISIBLE
                rdoPi.visibility=android.view.View.INVISIBLE
                rdoQ.visibility=android.view.View.INVISIBLE
                choice.visibility=android.view.View.INVISIBLE
            }
        }
        choice.setOnClickListener{
            when(rGroup1.checkedRadioButtonId){
                R.id.RdoOreo->imgAndroid.setImageResource(R.drawable.oreo)
                R.id.RdoPi->imgAndroid.setImageResource(R.drawable.pie)
                R.id.RdoQ->imgAndroid.setImageResource(R.drawable.q10)
                else->Toast.makeText(applicationContext,"안드로이드버전을 먼저 선택하세요",Toast.LENGTH_SHORT).show()
            }
            imgAndroid.visibility=android.view.View.VISIBLE
            choice.visibility=android.view.View.INVISIBLE
            finish.visibility=android.view.View.VISIBLE
            reset.visibility=android.view.View.VISIBLE
        }
        finish.setOnClickListener{
            finish()
        }
        reset.setOnClickListener{
            switchAgree.toggle()
            text2.visibility=android.view.View.INVISIBLE
            rGroup1.visibility=android.view.View.INVISIBLE
            rdoOreo.visibility=android.view.View.INVISIBLE
            rdoPi.visibility=android.view.View.INVISIBLE
            rdoQ.visibility=android.view.View.INVISIBLE
            finish.visibility=android.view.View.INVISIBLE
            reset.visibility=android.view.View.INVISIBLE
            imgAndroid.visibility=android.view.View.INVISIBLE
        }
    }
}