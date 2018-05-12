package com.example.xeltim.biologyjourney

import android.app.Activity
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Window
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : Activity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button2.setOnClickListener(){
            isNetworkConnected()
            var Status : Boolean = isNetworkConnected()
            if(Status === true){
                Start()
                startAlarm()
            }else{
                Toast.makeText(this@MainActivity, "No Internet Connection!", Toast.LENGTH_SHORT).show()
            }
        }

    }

    protected fun Start():Unit{
        var intent : Intent = Intent(this, Home::class.java)
        startActivity(intent)
    }

    protected fun Settings() : Unit{
        var intent : Intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent);
    }

    protected fun isNetworkConnected() : Boolean{
        var cm : ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.getActiveNetworkInfo() != null
    }

    private fun startAlarm(){
        var calendar:Calendar = Calendar.getInstance()

        calendar.set(Calendar.HOUR_OF_DAY, 9)
        calendar.set(Calendar.MINUTE, 45)
        calendar.set(Calendar.SECOND, 0)

        val pendingIntent = PendingIntent.getBroadcast(this, 100,
                Intent(this, AlarmReciver::class.java), PendingIntent.FLAG_UPDATE_CURRENT)

        val alarmManager = this.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.timeInMillis,
                AlarmManager.INTERVAL_FIFTEEN_MINUTES, pendingIntent)
    }

}