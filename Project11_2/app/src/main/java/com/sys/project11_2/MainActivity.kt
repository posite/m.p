package com.sys.project11_2

import java.util.ArrayList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var midList = ArrayList<String>()
        var list = findViewById<ListView>(R.id.listView1)

        var adapter = ArrayAdapter(this,  android.R.layout.simple_list_item_1, midList)
        list.adapter = adapter

        var edtItem = findViewById(R.id.edtItem) as EditText
        var btnAdd = findViewById(R.id.btnAdd) as Button

        btnAdd.setOnClickListener {
            midList.add(edtItem.text.toString())
            adapter.notifyDataSetChanged()
        }

        list.setOnItemLongClickListener { parent, view, position, id ->
            midList.removeAt(position)
            adapter.notifyDataSetChanged()
            false
        }
    }
}
