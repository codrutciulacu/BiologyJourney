package com.example.xeltim.biologyjourney

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmReciver(): BroadcastReceiver(){

    lateinit var mNotificationManager: NotificationManager

    companion object {
        val CHANNEL = 1100
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        mNotificationManager = NotificationManager(context)

        sendNotification(CHANNEL)
    }

    private fun sendNotification(id: Int){
        when(id){
            CHANNEL -> mNotificationManager.notify(CHANNEL, mNotificationManager.getNotification("What's the largest organ of the human body?", "Quite surprising, but the answer is your skin"))
        }
    }
}