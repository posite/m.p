package com.example.project6_3

import android.app.TabActivity
import android.os.Bundle
import android.widget.TabHost
import android.widget.TabHost.TabSpec

@Suppress("deprecation")
class MainActivity : TabActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tabHost = this.tabHost


        var tapDog = tabHost.newTabSpec("Dog").setIndicator("강아지")
        tapDog.setContent(R.id.dog)
        tabHost.addTab(tapDog)
        var tapCat = tabHost.newTabSpec("Cat").setIndicator("고양이")
        tapCat.setContent(R.id.cat)
        tabHost.addTab(tapCat)
        var tapRabbit = tabHost.newTabSpec("Rabbit").setIndicator("토끼")
        tapRabbit.setContent(R.id.rabbit)
        tabHost.addTab(tapRabbit)
        var tapHorse = tabHost.newTabSpec("Horse").setIndicator("말")
        tapHorse.setContent(R.id.horse)
        tabHost.addTab(tapHorse)


        tabHost.currentTab = 0
    }
}
