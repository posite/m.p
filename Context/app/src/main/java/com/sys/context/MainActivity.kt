package com.sys.context

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var button1 : Button
    lateinit var button2 : Button
    lateinit var baseLayout : LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1 = findViewById(R.id.button1)
        registerForContextMenu(button1)
        button2 = findViewById(R.id.button2)
        registerForContextMenu(button2)
        baseLayout = findViewById(R.id.baseLayout)

        var button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            //윈도우 매니저 객체로부터 display 객체 정보를 가져옴
            var display = (getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
            var xOffset = (Math.random() * display.width).toInt()
            var yOffset = (Math.random() * display.height).toInt()
            var tMsg = Toast.makeText(applicationContext, "$xOffset : $yOffset", Toast.LENGTH_SHORT)
            tMsg.setGravity(Gravity.TOP or Gravity.LEFT, xOffset, yOffset) //좌측 상단이 기준(0,0)
            tMsg.show()
        }
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        var mInflater = this.menuInflater
        if(v===button1){
            menu!!.setHeaderTitle("배경색 변경")
            mInflater.inflate(R.menu.menu0,menu)
        }
        if(v===button2){
            mInflater.inflate(R.menu.menu1,menu)
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
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
                button1.rotation = 45f
                return true
            }
            R.id.size -> {
                button1.scaleX = 2f
                return true
            }

        }
        return true
    }
}