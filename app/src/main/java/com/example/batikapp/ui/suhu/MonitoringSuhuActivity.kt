package com.example.batikapp.ui.suhu

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.example.batikapp.databinding.ActivityMonitoringSuhuBinding
import com.example.batikapp.ui.dashboard.DashboardActivity

class MonitoringSuhuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMonitoringSuhuBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMonitoringSuhuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackToDashboard.setOnClickListener {
            startActivity(
                Intent(this, DashboardActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            finishAffinity()
        }


        database = Firebase.database.reference

        // database.child("FirebaseIOT").child("temperature")


        val postListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val post = snapshot.child("FirebaseIOT").child("temperature").value.toString()
                try {
                    binding.monitoringSuhu.speedTo(post.toFloat(), 1000L)
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MonitoringSuhuActivity, error.message, Toast.LENGTH_SHORT).show()
            }

        }
        database.addValueEventListener(postListener)

    }


}