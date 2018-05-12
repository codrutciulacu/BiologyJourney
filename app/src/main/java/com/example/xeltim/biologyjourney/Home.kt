package com.example.xeltim.biologyjourney

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var mToolbar = findViewById<Toolbar>(R.id.toolbar) as Toolbar?
        setSupportActionBar(mToolbar)
    }

}