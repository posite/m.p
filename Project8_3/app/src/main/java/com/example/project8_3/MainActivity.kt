package com.example.project8_3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import java.io.*
import java.nio.Buffer
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var dp : DatePicker
    lateinit var edtDiary : EditText
    lateinit var btnWrite : Button
    lateinit var fileName : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "간단 일기장"

        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), Context.MODE_PRIVATE)
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), Context.MODE_PRIVATE)

        dp = findViewById<DatePicker>(R.id.datePicker1)
        edtDiary = findViewById<EditText>(R.id.edtDiary)
        btnWrite = findViewById<Button>(R.id.btnWrite)

        var cal = Calendar.getInstance()
        var cYear = cal.get(Calendar.YEAR)
        var cMonth = cal.get(Calendar.MONTH)
        var cDay = cal.get(Calendar.DAY_OF_MONTH)
        fileName = (Integer.toString(cYear) + "_"
                + Integer.toString(cMonth + 1) + "_"
                + Integer.toString(cDay) + ".txt")
        val reader :FileReader?
        val bReader : BufferedReader?
        var firstStr :String?=null
        val path = Environment.getExternalStorageDirectory().absolutePath
        var file = File(path + "/myDiary/")
        if(!file.exists()){
            file.mkdir()
        }
        try{
            var tmp:String?
            var result=""
            reader = FileReader(path+"/myDiary/"+fileName)
            bReader = BufferedReader(reader)
            var txt = ByteArray(500)
            while(true) {
                 tmp= bReader.readLine()  // 버퍼에서 한 줄을 꺼내 temp에 담고
                if(tmp == null) break  // 내용이 더 이상 없으면 빠져나가고,
                else result += tmp + "\n"  // 값이 있다면 result 변수에 추가
            }
            firstStr = result
            btnWrite.text = "수정 하기"
            edtDiary.setText(firstStr)
            btnWrite.isEnabled=true
            reader.close()
            bReader.close()
        }catch(e:IOException){
            edtDiary.hint = "일기 없음"
            btnWrite.text = "새로 저장"
            btnWrite.isEnabled=true
        }

        dp.init(cYear, cMonth, cDay) { view, year, monthOfYear, dayOfMonth ->
            fileName = (Integer.toString(year) + "_"
                    + Integer.toString(monthOfYear + 1) + "_"
                    + Integer.toString(dayOfMonth) + ".txt")
            var str = readDiary(fileName)
            edtDiary.setText(str)
            btnWrite.isEnabled = true
        }

        btnWrite.setOnClickListener {
            var writer : FileWriter?
            try{
                var str =edtDiary.text.toString()
                writer=FileWriter(Environment.getExternalStorageDirectory().absolutePath+ "/myDiary/"+fileName)
                val bWriter = BufferedWriter(writer)
                bWriter.write(str)
                bWriter.close()
                btnWrite.text = "수정 하기"
            }catch(e:IOException){
                edtDiary.hint = "일기 없음"
                btnWrite.text = "새로 저장"
            }

            Toast.makeText(applicationContext, "$fileName 이 저장됨", Toast.LENGTH_SHORT).show()
        }
    }

    fun readDiary(fName: String) : String? {
        var diaryStr : String? = null
        val fReader : FileReader?
        val bReader :BufferedReader?
        try {
            var tmp:String?
            var result=""
            fReader = FileReader(Environment.getExternalStorageDirectory().absolutePath + "/myDiary/"+fName)
            bReader= BufferedReader(fReader)
            while(true) {
                tmp= bReader.readLine()  // 버퍼에서 한 줄을 꺼내 temp에 담고
                if(tmp == null) break  // 내용이 더 이상 없으면 빠져나가고,
                else result += tmp + "\n"  // 값이 있다면 result 변수에 추가
            }
            diaryStr = result
            btnWrite.text = "수정 하기"
            fReader.close()
            bReader.close()
        } catch (e : IOException) {
            edtDiary.hint = "일기 없음"
            btnWrite.text = "새로 저장"
        }
        return diaryStr
    }
}
