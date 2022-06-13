package com.example.batikapp.service


import android.R
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.example.batikapp.ui.dashboard.DashboardActivity

@RequiresApi(Build.VERSION_CODES.O)
class FirebaseMessagingService : FirebaseMessagingService() {

    companion object {
        private val TAG = FirebaseMessagingService::class.java
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        Log.d(TAG.toString(), "From: " + remoteMessage.from)

        sendNotification(remoteMessage)


        if (remoteMessage.data.isNotEmpty()) {
            Log.d(TAG.toString(), "Message data payload: " + remoteMessage.data)

            if (remoteMessage.notification != null) {
                Log.d(TAG.toString(),
                    "Message Notification Body: " + remoteMessage.notification!!.body)
            }
        }


    }

    override fun onNewToken(newToken: String) {
        super.onNewToken(newToken)

        Log.d(TAG.toString(), "Refreshed token: $newToken");

    }


    private fun sendNotification(remoteMessage: RemoteMessage) {
        val channelId = "batik-app"
        val channelName = "Pengingat Kain Kering"


        val intentToDashboard = Intent(this, DashboardActivity::class.java)
        intentToDashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intentToDashboard,
            PendingIntent.FLAG_IMMUTABLE
        )


        val defaultSoundUri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_menu_agenda)
            .setContentTitle(remoteMessage.notification?.title)
            .setContentText(remoteMessage.notification?.body)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setVibrate(longArrayOf(1000, 1000, 1000))
            .setSound(defaultSoundUri)

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


        // Kebijakan baru android oreo
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)

        }
        notificationManager.notify(0, notificationBuilder.build())

    }


}

