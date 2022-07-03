package com.sys.project11_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "리스트뷰 테스트"

        var mid = arrayOf("히어로즈", "24시", "로스트", "로스트룸", "스몰빌", "탐정몽크", "빅뱅이론", "프렌즈", "덱스터", "글리", "가쉽걸", "테이큰", "슈퍼내추럴", "브이")

        var list = findViewById<View>(R.id.listView1) as ListView

        var adapter : ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, mid)
        list.adapter = adapter

        list.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(applicationContext, mid[position], Toast.LENGTH_SHORT).show()
        }
    }
}
