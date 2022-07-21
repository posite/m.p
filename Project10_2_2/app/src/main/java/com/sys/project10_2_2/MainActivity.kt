package com.sys.project10_2_2

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "메인 액티비티"
        var calc = findViewById<RadioGroup>(R.id.calc)
        var btnNewActivity = findViewById<Button>(R.id.btnNewActivity)
        btnNewActivity.setOnClickListener {
            var edtNum1 = findViewById<EditText>(R.id.edtNum1)
            var edtNum2 = findViewById<EditText>(R.id.edtNum2)

            when (calc.checkedRadioButtonId) {
                R.id.btnAdd -> {
                    var intent = Intent(applicationContext, SecondActivity::class.java)
                    intent.putExtra("Num1", Integer.parseInt(edtNum1.text.toString()))
                    intent.putExtra("Num2", Integer.parseInt(edtNum2.text.toString()))
                    intent.putExtra("Calculate", "add")
                    startActivityForResult(intent, 0)
                }
                R.id.btnSub -> {
                    var intent = Intent(applicationContext, SecondActivity::class.java)
                    intent.putExtra("Num1", Integer.parseInt(edtNum1.text.toString()))
                    intent.putExtra("Num2", Integer.parseInt(edtNum2.text.toString()))
                    intent.putExtra("Calculate", "sub")
                    startActivityForResult(intent, 0)
                }
                R.id.btnMul -> {
                    var intent = Intent(applicationContext, SecondActivity::class.java)
                    intent.putExtra("Num1", Integer.parseInt(edtNum1.text.toString()))
                    intent.putExtra("Num2", Integer.parseInt(edtNum2.text.toString()))
                    intent.putExtra("Calculate", "mul")
                    startActivityForResult(intent, 0)
                }
                R.id.btnDiv -> {
                    var intent = Intent(applicationContext, SecondActivity::class.java)
                    intent.putExtra("Num1", Integer.parseInt(edtNum1.text.toString()))
                    intent.putExtra("Num2", Integer.parseInt(edtNum2.text.toString()))
                    intent.putExtra("Calculate", "div")
                    startActivityForResult(intent, 0)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            var hap = data!!.getIntExtra("Result", 0)
            Toast.makeText(applicationContext, "결과 :$hap", Toast.LENGTH_SHORT).show()
        }
    }
}