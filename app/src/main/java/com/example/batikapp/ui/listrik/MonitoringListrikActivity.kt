package com.example.batikapp.ui.listrik

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
import com.example.batikapp.databinding.ActivityMonitoringListrikBinding
import com.example.batikapp.ui.dashboard.DashboardActivity

class MonitoringListrikActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMonitoringListrikBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMonitoringListrikBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackToDashboard.setOnClickListener {
            startActivity(
                Intent(this, DashboardActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            finishAffinity()
        }

        databaseReference = Firebase.database.reference

        val postListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                try {
                    val arus = snapshot.child("listrik").child("arus").value.toString()
                    val daya = snapshot.child("listrik").child("daya").value.toString()
                    val tegangan = snapshot.child("listrik").child("tegangan").value.toString()
                    val frekuensi = snapshot.child("listrik").child("frekuensi").value.toString()

                    binding.apply {
                        "$arus A".also { dataArus.text = it }
                        "$daya W".also { dataDaya.text = it }
                        "$tegangan V".also { dataTegangan.text = it }
                        "$frekuensi Hz".also { dataFrekuensi.text = it }
                    }

                } catch (e: Exception) {
                    e.printStackTrace()
                }


            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MonitoringListrikActivity, error.message, Toast.LENGTH_SHORT).show()
            }

        }

        databaseReference.addValueEventListener(postListener)
    }
}