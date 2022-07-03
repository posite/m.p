package com.example.project5_3

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

     lateinit internal var img1 : ImageView
     lateinit internal var img2 : ImageView
     lateinit internal var img3 : ImageView
     lateinit internal var changeBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var i : Int=1
        setContentView(R.layout.activity_main)
        img1=findViewById<ImageView>(R.id.Img1)
        img2=findViewById<ImageView>(R.id.Img2)
        img3=findViewById<ImageView>(R.id.Img3)
        changeBtn=findViewById<Button>(R.id.Btn)
        changeBtn.setOnClickListener {
            if(i%3==1){
                img1.visibility=android.view.View.VISIBLE
                img2.visibility=android.view.View.INVISIBLE
                img3.visibility=android.view.View.INVISIBLE
                i++
                false
            }else if(i%3==2){
                img1.visibility=android.view.View.INVISIBLE
                img2.visibility=android.view.View.VISIBLE
                img3.visibility=android.view.View.INVISIBLE
                i++
                false
            }else{
                img1.visibility=android.view.View.INVISIBLE
                img2.visibility=android.view.View.INVISIBLE
                img3.visibility=android.view.View.VISIBLE
                i++
                false
            }
        }
    }
}