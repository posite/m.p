package com.example.project6_1

import android.graphics.Color
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var chrono : Chronometer

    lateinit var rdoCal : RadioButton
    lateinit var rdoTime : RadioButton

    lateinit var tPicker : TimePicker
    lateinit var tvYear : TextView
    lateinit var tvMonth : TextView
    lateinit var tvDay : TextView
    lateinit var tvHour : TextView
    lateinit var tvMinute : TextView
    lateinit var dPicker : DatePicker
    var selectYear : Int = 0
    var selectMonth : Int = 0
    var selectDay : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "시간 예약"

        var cal = Calendar.getInstance()
        var cYear = cal.get(Calendar.YEAR)
        var cMonth = cal.get(Calendar.MONTH)
        var cDay = cal.get(Calendar.DAY_OF_MONTH)

        // 크로노미터
        chrono = findViewById<Chronometer>(R.id.chronometer1)

        // 라디오버튼 2개
        rdoCal = findViewById<RadioButton>(R.id.rdoCal)
        rdoTime = findViewById<RadioButton>(R.id.rdoTime)

        // FrameLayout의 3개 위젯
        tPicker = findViewById<TimePicker>(R.id.timePicker1)

        dPicker = findViewById<DatePicker>(R.id.datePicker1)

        // 텍스트뷰 중에서 연,월,일,시,분 숫자
        tvYear = findViewById<TextView>(R.id.tvYear)
        tvMonth = findViewById<TextView>(R.id.tvMonth)
        tvDay = findViewById<TextView>(R.id.tvDay)
        tvHour = findViewById<TextView>(R.id.tvHour)
        tvMinute = findViewById<TextView>(R.id.tvMinute)

        dPicker.init(cYear,cMonth,cDay){ view,year,monthOfYear,dayOfMonth->
            selectYear=year
            selectMonth=monthOfYear
            selectDay=dayOfMonth
        }
        // 처음에는 안보이게 설정
        tPicker.visibility = View.INVISIBLE
        dPicker.visibility = View.INVISIBLE

        rdoTime.visibility = View.INVISIBLE
        rdoCal.visibility = View.INVISIBLE

        rdoCal.setOnClickListener {
            tPicker.visibility = View.INVISIBLE

            dPicker.visibility = View.VISIBLE
        }

        rdoTime.setOnClickListener {
            tPicker.visibility = View.VISIBLE

            dPicker.visibility = View.INVISIBLE
        }

        // 타이머 설정
        chrono.setOnClickListener {
            chrono.base = SystemClock.elapsedRealtime()
            chrono.start()
            chrono.setTextColor(Color.RED)
            rdoCal.visibility=View.VISIBLE
            rdoTime.visibility=View.VISIBLE

        }

        // 버튼을 클릭하면 날짜,시간을 가져온다.
        tvYear.setOnLongClickListener {
            chrono.stop()
            chrono.setTextColor(Color.BLUE)

            tvYear.text = Integer.toString(selectYear)
            tvMonth.text = Integer.toString(selectMonth)
            tvDay.text = Integer.toString(selectDay)

            tvHour.text = Integer.toString(tPicker.currentHour)
            tvMinute.text = Integer.toString(tPicker.currentMinute)
            tPicker.visibility = View.INVISIBLE
            dPicker.visibility = View.INVISIBLE

            rdoTime.visibility = View.INVISIBLE
            rdoCal.visibility = View.INVISIBLE

            return@setOnLongClickListener(true)
        }


    }
}
