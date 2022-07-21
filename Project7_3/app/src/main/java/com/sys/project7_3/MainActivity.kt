package com.sys.project7_3

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var tvName : TextView
    lateinit var tvEmail : TextView
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

        tvName = findViewById<TextView>(R.id.tvName)
        tvEmail = findViewById<TextView>(R.id.tvEmail)
        button1 = findViewById<Button>(R.id.button1)

        button1.setOnClickListener {
            dialogView = View.inflate(this@MainActivity, R.layout.dialog1, null)
            var dlg = AlertDialog.Builder(this@MainActivity)
            dlg.setTitle("사용자 정보 입력")
            dlg.setIcon(R.mipmap.ic_launcher_round)
            dlg.setView(dialogView)
            dlg.setPositiveButton("확인") { dialog, which ->
                dlgEdtName = dialogView.findViewById<EditText>(R.id.dlgEdt1)
                dlgEdtEmail = dialogView.findViewById<EditText>(R.id.dlgEdt2)

                tvName.text ="사용자 이름 : " + dlgEdtName.text.toString()
                tvEmail.text ="이메일 : " + dlgEdtEmail.text.toString()
            }
            dlg.setNegativeButton("취소") { dialog, which ->
                var toast = Toast(this@MainActivity)
                toastView = View.inflate(this@MainActivity, R.layout.toast1,null)
                toastText = toastView .findViewById<TextView>(R.id.toastText1)
                toastText.text = "취소했습니다"
                toast.view = toastView
                toast.show()
            }
            dlg.show()
        }
    }
}
