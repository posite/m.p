package com.sys.project13_1

import android.content.Context
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.SystemClock
import android.view.View
import android.widget.*
import androidx.core.app.ActivityCompat
import java.io.File
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {
    var listViewMP3: ListView? = null
    lateinit var btnPlay: Button
    lateinit var btnStop: Button
    lateinit var tvMP3: TextView
    lateinit var pbMP3: SeekBar
    lateinit var mp3List: ArrayList<String>
    lateinit var selectedMP3: String
    var mp3Path = Environment.getExternalStorageDirectory().path + "/"
    lateinit var mPlayer: MediaPlayer
    lateinit var tvTime : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "간단 M4A 플레이어"
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), Context.MODE_PRIVATE)
        mp3List = ArrayList()
        var listFiles = File(mp3Path).listFiles()
        var fileName: String
        var extName: String
        for (file in listFiles!!) {
            fileName = file.name
            extName = fileName.substring(fileName.length - 3)
            if (extName == "m4a")
                mp3List.add(fileName)
        }
        var listViewMP3 = findViewById<ListView>(R.id.listViewMP3)
        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, mp3List)
        listViewMP3.choiceMode = ListView.CHOICE_MODE_SINGLE
        listViewMP3.adapter = adapter
        listViewMP3.setItemChecked(0, true)
        listViewMP3.setOnItemClickListener{ arg0, arg1, arg2, arg3 ->
            selectedMP3 = mp3List[arg2]
        }
        selectedMP3 = mp3List[0]
        btnPlay = findViewById<Button>(R.id.btnPlay)
        btnStop = findViewById<Button>(R.id.btnStop)
        tvMP3 = findViewById<TextView>(R.id.tvMP3)
        pbMP3 = findViewById<SeekBar>(R.id.pbMP3)
        tvTime=findViewById<TextView>(R.id.tvTime)
        btnPlay.setOnClickListener {
            mPlayer = MediaPlayer()
            mPlayer.setDataSource(mp3Path + selectedMP3)
            mPlayer.prepare()
            mPlayer.start()
            btnPlay.isClickable = false
            btnStop.isClickable = true
            tvMP3.text = "실행중인 음악 : $selectedMP3"
            pbMP3.visibility = View.VISIBLE
            object:Thread(){
                var timeFormat= SimpleDateFormat("mm:ss")
                override fun run() {
                    if(mPlayer==null)
                        return
                    pbMP3.max=mPlayer.duration
                    while(mPlayer.isPlaying){
                        runOnUiThread {
                            pbMP3.progress=mPlayer.currentPosition
                            tvTime.text="진행 시간 : "+timeFormat.format(mPlayer.currentPosition)
                        }
                        SystemClock.sleep(200)
                    }
                }
            }.start()
        }
        btnStop.setOnClickListener {
            mPlayer.stop()
            //mPlayer.reset()
            btnPlay.isClickable = true
            btnStop.isClickable = false
            tvMP3.text = "실행중인 음악 : "
            pbMP3.visibility = View.INVISIBLE
        }
        pbMP3.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if(p2){
                    mPlayer.seekTo(pbMP3.progress)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
        btnStop.isClickable = false

    }
}