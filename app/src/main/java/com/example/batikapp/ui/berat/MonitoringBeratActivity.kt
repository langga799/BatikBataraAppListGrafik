package com.example.batikapp.ui.berat

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.example.batikapp.databinding.ActivityMonitoringBeratBinding
import com.example.batikapp.ui.dashboard.DashboardActivity

class MonitoringBeratActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMonitoringBeratBinding
    private lateinit var database: DatabaseReference

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMonitoringBeratBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackToDashboard.setOnClickListener {
            startActivity(
                Intent(this, DashboardActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            finishAffinity()
        }


        database = Firebase.database.reference


        monitoringBeratKain1()
        monitoringBeratKain2()
        monitoringBeratKain3()
        monitoringBeratKain4()
        monitoringBeratKain5()

    }

    private fun monitoringBeratKain1() {
        val postListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val post = snapshot.child("berat").child("kain_1").value.toString()
                try {
                    binding.apply {
                        beratKain1.progress = post.toFloat()
                        beratKain1.max = 1000F
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MonitoringBeratActivity, error.message, Toast.LENGTH_SHORT).show()
            }

        }
        database.addValueEventListener(postListener)
    }


    private fun monitoringBeratKain2() {
        val postListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val post = snapshot.child("berat").child("kain_2").value.toString()
                try {
                    binding.apply {
                        beratKain2.progress = post.toFloat()
                        beratKain2.max = 1000F
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MonitoringBeratActivity, error.message, Toast.LENGTH_SHORT).show()
            }

        }
        database.addValueEventListener(postListener)
    }


    private fun monitoringBeratKain3() {
        val postListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val post = snapshot.child("berat").child("kain_3").value.toString()
                try {
                    binding.apply {
                        beratKain3.progress = post.toFloat()
                        beratKain3.max = 1000F
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MonitoringBeratActivity, error.message, Toast.LENGTH_SHORT).show()
            }

        }
        database.addValueEventListener(postListener)
    }


    private fun monitoringBeratKain4() {
        val postListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val post = snapshot.child("berat").child("kain_4").value.toString()
                try {
                    binding.apply {
                        beratKain4.progress = post.toFloat()
                        beratKain4.max = 1000F
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MonitoringBeratActivity, error.message, Toast.LENGTH_SHORT).show()
            }

        }
        database.addValueEventListener(postListener)
    }


    private fun monitoringBeratKain5() {
        val postListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val post = snapshot.child("berat").child("kain_5").value.toString()
                try {
                    binding.apply {
                        beratKain5.progress = post.toFloat()
                        beratKain5.max = 1000F
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MonitoringBeratActivity, error.message, Toast.LENGTH_SHORT).show()
            }

        }
        database.addValueEventListener(postListener)
    }
}