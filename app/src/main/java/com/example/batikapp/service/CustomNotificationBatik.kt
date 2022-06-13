package com.example.batikapp.service


import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.batikapp.R
import com.example.batikapp.ui.dashboard.DashboardActivity

@RequiresApi(Build.VERSION_CODES.O)
class CustomNotificationBatik : BroadcastReceiver() {

    var message1 = ""
    var message2 = ""
    var message3 = ""
    var message4 = ""
    var message5 = ""

    override fun onReceive(context: Context, intent: Intent?) {
        val message = intent?.getStringExtra(MESSAGE)
        notificationGrouping(context)

        if (message != null) {
            message1 = MESSAGE
            message2 = message
            message3 = message
            message4 = message
            message5 = message
        }

        Log.d("dataki", "$message $message1")
    }

    private fun notificationGrouping(context: Context) {
        val intentToDashboard = Intent(context, DashboardActivity::class.java)
        intentToDashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
            context,
            REQUEST_CODE,
            intentToDashboard,
            PendingIntent.FLAG_ONE_SHOT
        )

        val notifSound1 = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val newNotificationMessage1 = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.ic_baseline_android_24)
            .setContentTitle("Baba Apps")
            .setContentText(message1)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setVibrate(longArrayOf(1000, 1000, 1000))
            .setSound(notifSound1)
            .setGroup(GROUP_KEY_NOTIFICATION_BATIK)
            .build()


        val notifSound2 = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val newNotificationMessage2 = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.ic_baseline_android_24)
            .setContentTitle("Baba Apps")
            .setContentText(message2)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setVibrate(longArrayOf(1000, 1000, 1000))
            .setSound(notifSound2)
            .setGroup(GROUP_KEY_NOTIFICATION_BATIK)
            .build()

        val notifSound3 = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val newNotificationMessage3 = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.ic_baseline_android_24)
            .setContentTitle("Baba Apps")
            .setContentText(message3)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setVibrate(longArrayOf(1000, 1000, 1000))
            .setSound(notifSound3)
            .setGroup(GROUP_KEY_NOTIFICATION_BATIK)
            .build()


        val notifSound4 = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val newNotificationMessage4 = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.ic_baseline_android_24)
            .setContentTitle("Baba Apps")
            .setContentText(message4)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setVibrate(longArrayOf(1000, 1000, 1000))
            .setSound(notifSound4)
            .setGroup(GROUP_KEY_NOTIFICATION_BATIK)
            .build()


        val notifSound5 = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val newNotificationMessage5 = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.ic_baseline_android_24)
            .setContentTitle("Baba Apps")
            .setContentText(message5)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setVibrate(longArrayOf(1000, 1000, 1000))
            .setSound(notifSound5)
            .setGroup(GROUP_KEY_NOTIFICATION_BATIK)
            .build()


        val summaryNotification = NotificationCompat.Builder(context, channelId)
            .setContentTitle("Pemberitahuan Kain Kering")
            .setSmallIcon(R.drawable.ic_baseline_android_24)
            //build summary info into InboxStyle template
            .setStyle(NotificationCompat.InboxStyle())
            //specify which group this notification belongs to
            .setGroup(GROUP_KEY_NOTIFICATION_BATIK)
            //set this notification as the summary for the group
            .setGroupSummary(true)
            .build()


        NotificationManagerCompat.from(context).apply {
            notify(KAIN_ID_1, newNotificationMessage1)
            notify(KAIN_ID_2, newNotificationMessage2)
            notify(KAIN_ID_3, newNotificationMessage3)
            notify(KAIN_ID_4, newNotificationMessage4)
            notify(KAIN_ID_5, newNotificationMessage5)
            notify(SUMMARY_ID, summaryNotification)
        }


    }


    companion object {
        const val channelId = "batik-app"

        const val MESSAGE = "message"
        const val REQUEST_CODE = 100

        const val KAIN_ID_1 = 1
        const val KAIN_ID_2 = 2
        const val KAIN_ID_3 = 3
        const val KAIN_ID_4 = 4
        const val KAIN_ID_5 = 5

        const val SUMMARY_ID = 0
        const val GROUP_KEY_NOTIFICATION_BATIK = "com.example.batikapp.NOTIF_KAIN"
    }


}