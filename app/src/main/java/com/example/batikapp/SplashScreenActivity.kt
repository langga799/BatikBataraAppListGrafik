package com.example.batikapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.batikapp.databinding.ActivitySplashScreenBinding
import com.example.batikapp.ui.dashboard.DashboardActivity
import com.google.firebase.messaging.FirebaseMessaging
import com.ahmedabdelmeged.bluetoothmc.BluetoothMC


@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, DashboardActivity::class.java))
            finishAffinity()
        }, TIME_DELAY)

        FirebaseMessaging.getInstance().token
            .addOnCompleteListener { task ->
                val token: String = task.result!!
                Log.d("token", token)
            }

    }

    companion object {
        private const val TIME_DELAY = 1000L
    }
}

