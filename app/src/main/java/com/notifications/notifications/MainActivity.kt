package com.notifications.notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPersistentChannelId(this, NotificationManager.IMPORTANCE_MIN)
        getPersistentChannelId(this, NotificationManager.IMPORTANCE_LOW)
        getPersistentChannelId(this, NotificationManager.IMPORTANCE_DEFAULT)
        getPersistentChannelId(this, NotificationManager.IMPORTANCE_HIGH)
        getPersistentChannelId(this, NotificationManager.IMPORTANCE_MAX)
        getPersistentChannelId(this, NotificationManager.IMPORTANCE_NONE)
        getPersistentChannelId(this, NotificationManager.IMPORTANCE_UNSPECIFIED)

    }

    fun getPersistentChannelId(context: Context, importance: Int): String {
        val id = "my_channel_${System.currentTimeMillis()}_$importance"
        Log.d("MainActivity", "getPersistentChannelId $id")
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        var channel = notificationManager.getNotificationChannel(id)
        if (channel == null) {
            val name = "name for $id"
            val description = "description for $id"
            channel = NotificationChannel(id, name, importance)
            channel.description = description
            channel.enableLights(false)
            channel.enableVibration(false)
            channel.setShowBadge(BuildConfig.DEBUG)
            channel.lockscreenVisibility = Notification.VISIBILITY_SECRET
            notificationManager.createNotificationChannel(channel)
        }
        return id
    }

}
