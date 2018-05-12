package com.example.xeltim.biologyjourney

import android.app.*
import android.app.NotificationManager
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Color
import android.os.Build

class NotificationManager(context: Context?): ContextWrapper(context){


    companion object {
        val CHANNEL = "Notification"
    }

    private val mNotificatinManager: NotificationManager by lazy{
        getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    init{
        initChannel()
    }

    public fun initChannel(): Unit{
        if(Build.VERSION.SDK_INT < 26){
            return;
        }
        val channel: NotificationChannel? = NotificationChannel(CHANNEL,
                getString(R.string.notification_channel),
                NotificationManager.IMPORTANCE_LOW)

        channel?.lightColor = Color.GREEN
        channel?.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 500, 200, 500)

        mNotificatinManager.createNotificationChannel(channel)
    }

    public fun getNotification(title: String, text: String): Notification.Builder{
        return Notification.Builder(applicationContext)
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(R.drawable.icon)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
    }

    private val pendingIntent: PendingIntent
        get(){
            val intent = Intent(this@NotificationManager, MainActivity::class.java)
            val taskBuilder = TaskStackBuilder.create(this)
            taskBuilder.addParentStack(MainActivity::class.java)
            taskBuilder.addNextIntent(intent)
            return taskBuilder.getPendingIntent(0, PendingIntent.FLAG_ONE_SHOT)
        }

    fun notify(id: Int, notif: Notification.Builder){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mNotificatinManager.notify(id, notif.build())
        }
    }


}