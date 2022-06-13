package com.example.batikapp.service


import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.batikapp.R
import com.example.batikapp.ui.dashboard.DashboardActivity

@RequiresApi(Build.VERSION_CODES.O)
class CustomNotification : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent?) {
        val message = intent?.getStringExtra(MESSAGE)
        sendNotification1(context, message)
        sendNotification2(context, message)
        sendNotification3(context, message)
        sendNotification4(context, message)
        sendNotification5(context, message)
    }



    @SuppressLint("UnspecifiedImmutableFlag")
    fun sendNotification1(context: Context, message: String?) {
        val channelId = "batik-app"
        val channelName = "Pengingat Kain Kering"

        val intentToDashboard = Intent(context, DashboardActivity::class.java)
        intentToDashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
            context,
            REQUEST_CODE,
            intentToDashboard,
            PendingIntent.FLAG_ONE_SHOT
        )

        val notifSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val newNotificationMessage1 = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.ic_baseline_android_24)
            .setContentTitle("Baba Apps")
            .setContentText(message)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setVibrate(longArrayOf(1000, 1000, 1000))
            .setSound(notifSound)
            .setGroup(GROUP_KEY_NOTIFICATION_BATIK)
            .build()


        val summaryNotification = NotificationCompat.Builder(context, channelId)
            .setContentTitle("Pemberitahuan Kain Kering")
            .setSmallIcon(R.drawable.ic_baseline_android_24)
            //build summary info into InboxStyle template
            .setStyle(NotificationCompat.InboxStyle()
                .addLine("Alex Faarborg Check this out")
                .addLine("Jeff Chang Launch Party")
                .setBigContentTitle("2 new messages")
                .setSummaryText("janedoe@example.com"))
            //specify which group this notification belongs to
            .setGroup(GROUP_KEY_NOTIFICATION_BATIK)
            //set this notification as the summary for the group
            .setGroupSummary(true)
            .build()


        NotificationManagerCompat.from(context).apply {
            notify(KAIN_ID_1, newNotificationMessage1)
            notify(SUMMARY_ID, summaryNotification)
        }

    }

    @SuppressLint("UnspecifiedImmutableFlag")
    fun sendNotification2(context: Context, message: String?) {
        val channelId = "batik-app"
        val channelName = "Pengingat Kain Kering"

        val intentToDashboard = Intent(context, DashboardActivity::class.java)
        intentToDashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
            context,
            REQUEST_CODE,
            intentToDashboard,
            PendingIntent.FLAG_ONE_SHOT
        )

        val notifSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val newNotificationMessage2 = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.ic_baseline_android_24)
            .setContentTitle("Baba Apps")
            .setContentText(message)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setVibrate(longArrayOf(1000, 1000, 1000))
            .setSound(notifSound)
            .setGroup(GROUP_KEY_NOTIFICATION_BATIK)
            .build()


        val summaryNotification = NotificationCompat.Builder(context, channelId)
            .setContentTitle("Pemberitahuan Kain Kering")
            .setSmallIcon(R.drawable.ic_baseline_android_24)
            //build summary info into InboxStyle template
            .setStyle(NotificationCompat.InboxStyle()
                .addLine("Alex Faarborg Check this out")
                .addLine("Jeff Chang Launch Party")
                .setBigContentTitle("2 new messages")
                .setSummaryText("janedoe@example.com"))
            //specify which group this notification belongs to
            .setGroup(GROUP_KEY_NOTIFICATION_BATIK)
            //set this notification as the summary for the group
            .setGroupSummary(true)
            .build()


        NotificationManagerCompat.from(context).apply {
            notify(KAIN_ID_2, newNotificationMessage2)
            notify(SUMMARY_ID, summaryNotification)
        }
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    fun sendNotification3(context: Context, message: String?) {
        val channelId = "batik-app"
        val channelName = "Pengingat Kain Kering"

        val intentToDashboard = Intent(context, DashboardActivity::class.java)
        intentToDashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
            context,
            REQUEST_CODE,
            intentToDashboard,
            PendingIntent.FLAG_ONE_SHOT
        )

        val notifSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val newNotificationMessage3 = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.ic_baseline_android_24)
            .setContentTitle("Baba Apps")
            .setContentText(message)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setVibrate(longArrayOf(1000, 1000, 1000))
            .setSound(notifSound)
            .setGroup(GROUP_KEY_NOTIFICATION_BATIK)
            .build()



        val summaryNotification = NotificationCompat.Builder(context, channelId)
            .setContentTitle("Pemberitahuan Kain Kering")
            .setSmallIcon(R.drawable.ic_baseline_android_24)
            //build summary info into InboxStyle template
            .setStyle(NotificationCompat.InboxStyle()
                .addLine("Alex Faarborg Check this out")
                .addLine("Jeff Chang Launch Party")
                .setBigContentTitle("2 new messages")
                .setSummaryText("janedoe@example.com"))
            //specify which group this notification belongs to
            .setGroup(GROUP_KEY_NOTIFICATION_BATIK)
            //set this notification as the summary for the group
            .setGroupSummary(true)
            .build()


        NotificationManagerCompat.from(context).apply {
            notify(KAIN_ID_3, newNotificationMessage3)
            notify(SUMMARY_ID, summaryNotification)
        }
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    fun sendNotification4(context: Context, message: String?) {
        val channelId = "batik-app"
        val channelName = "Pengingat Kain Kering"

        val intentToDashboard = Intent(context, DashboardActivity::class.java)
        intentToDashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
            context,
            REQUEST_CODE,
            intentToDashboard,
            PendingIntent.FLAG_ONE_SHOT
        )

        val notifSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val newNotificationMessage4 = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.ic_baseline_android_24)
            .setContentTitle("Baba Apps")
            .setContentText(message)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setVibrate(longArrayOf(1000, 1000, 1000))
            .setSound(notifSound)
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
            notify(KAIN_ID_4, newNotificationMessage4)
            notify(SUMMARY_ID, summaryNotification)
        }
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    fun sendNotification5(context: Context, message: String?) {
        val channelId = "batik-app"
        val channelName = "Pengingat Kain Kering"


        val intentToDashboard = Intent(context, DashboardActivity::class.java)
        intentToDashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
            context,
            REQUEST_CODE,
            intentToDashboard,
            PendingIntent.FLAG_ONE_SHOT
        )

        val notifSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val newNotificationMessage5 = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.ic_baseline_android_24)
            .setContentTitle("Baba Apps")
            .setContentText(message)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setVibrate(longArrayOf(1000, 1000, 1000))
            .setSound(notifSound)
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
            notify(KAIN_ID_5, newNotificationMessage5)
            notify(SUMMARY_ID, summaryNotification)
        }
    }

    companion object {
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