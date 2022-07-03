package com.example.project7_2

import android.app.AlertDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edName : EditText
    lateinit var edEmail : EditText
    lateinit var button1 : Button
    lateinit var dlgEdtName : EditText
    lateinit var dlgEdtEmail : EditText
    lateinit var toastText : TextView
    lateinit var dialogView : View
    lateinit var toastView : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "사용자 정보 입력"

        edName = findViewById<EditText>(R.id.etName)
        edEmail = findViewById<EditText>(R.id.etEmail)
        button1 = findViewById<Button>(R.id.button1)

        button1.setOnClickListener {
            dialogView = View.inflate(this@MainActivity, R.layout.dialog1, null)
            var dlg = AlertDialog.Builder(this@MainActivity)
            dlg.setTitle("사용자 정보 입력")
            dlg.setView(dialogView)
            dlgEdtName = dialogView.findViewById<EditText>(R.id.dlgEdt1)
            dlgEdtEmail = dialogView.findViewById<EditText>(R.id.dlgEdt2)
            dlgEdtName.text=edName.text
            dlgEdtEmail.text=edEmail.text
            dlg.setPositiveButton("확인") { dialog, which ->


                edName.text = dlgEdtName.text
                edEmail.text = dlgEdtEmail.text
            }
            dlg.setNegativeButton("취소") { dialog, which ->
                var toast = Toast(this@MainActivity)
                var display = (getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
                var xOffset = (Math.random() * display.width).toInt()
                var yOffset = (Math.random() * display.height).toInt()
                toastView = View.inflate(this@MainActivity, R.layout.toast1,null)
                toastText = toastView .findViewById<TextView>(R.id.toastText1)
                toastText.text = "취소했습니다"
                toast.setGravity(Gravity.TOP or Gravity.LEFT,xOffset,yOffset)
                toast.view = toastView
                toast.show()
            }
            dlg.show()
        }
    }
}
