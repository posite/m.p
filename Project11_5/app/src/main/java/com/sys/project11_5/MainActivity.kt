package com.sys.project11_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "스피너 테스트"

        var movie = arrayOf("쿵푸팬더", "짱구는 못말려",
            "아저씨", "아바타", "대부", "국가대표", "토이스토리3",
            "마당을 나온 암탉", "죽은 시인의 사회", "서유기")
        var mid=arrayOf(R.drawable.mov21,R.drawable.mov22,R.drawable.mov23,
            R.drawable.mov24,R.drawable.mov25,R.drawable.mov26,
            R.drawable.mov27,R.drawable.mov28,R.drawable.mov29,R.drawable.mov30)

        var spinner = findViewById<Spinner>(R.id.spinner1)

        var adapter: ArrayAdapter<String>
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, movie)
        spinner.adapter = adapter
        spinner.onItemSelectedListener= object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                var img = findViewById<ImageView>(R.id.img1)
                img.scaleType=ImageView.ScaleType.FIT_CENTER
                img.setPadding(5,5,5,5)
                img.setImageResource(mid[p2])
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

    }

}