package com.example.batikapp.ui.control

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.batikapp.R
import com.example.batikapp.databinding.ActivityControlBinding
import com.example.batikapp.ui.dashboard.DashboardActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
class ControlActivity : AppCompatActivity() {

    private lateinit var binding: ActivityControlBinding
    private lateinit var databaseReference: DatabaseReference
    private lateinit var fire: FirebaseFirestore

    private var arus = ""
    private var daya = ""
    private var tegangan = ""
    private var frekuensi = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityControlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseReference = Firebase.database.reference
        fire = Firebase.firestore


        binding.btnBackToDashboard.setOnClickListener {
            startActivity(
                Intent(this, DashboardActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            finishAffinity()
        }


        val getDataControl = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                when (snapshot.child("control_pemanas").child("pemanas").value.toString()) {
                    "1" -> {
                        binding.imageContainerControl.setImageResource(R.drawable.ic_control_on)
                        binding.switchControl.setChecked(true)
                        binding.tvState.text = "Pemanas dihidupkan"
                    }
                    "0" -> {
                        binding.imageContainerControl.setImageResource(R.drawable.ic_control)
                        binding.tvState.text = "Pemanas dimatikan"
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@ControlActivity, error.message, Toast.LENGTH_SHORT).show()
            }

        }
        databaseReference.addValueEventListener(getDataControl)



        getDataDaya()
        getDataArus()
        getDataTegangan()
        getDataFrekuensi()


        setControlPemanas()

    }

    private fun setControlPemanas() {
        binding.switchControl.setChecked(false)
        binding.switchControl.setOnCheckedChangeListener { statusPemanas ->
            val reference = databaseReference.child("control_pemanas").child("pemanas")
            when {
                statusPemanas -> {
                    reference.setValue("1")
                    binding.imageContainerControl.setImageResource(R.drawable.ic_control_on)
                    binding.tvState.text = "Pemanas dihidupkan"
                    binding.switchControl.setChecked(true)
                }
                else -> {
                    reference.setValue("0")
                    binding.tvState.text = "Pemanas dimatikan"

                    sendHistoryToFirestore()
                }
            }
        }
    }

    private fun getDataDaya() {
        databaseReference.child("listrik").child("daya")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    daya = snapshot.value.toString()
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
    }

    private fun getDataArus() {
        databaseReference.child("listrik").child("arus")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    arus = snapshot.value.toString()
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
    }

    private fun getDataTegangan() {
        databaseReference.child("listrik").child("tegangan")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    tegangan = snapshot.value.toString()
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
    }

    private fun getDataFrekuensi() {
        databaseReference.child("listrik").child("frekuensi")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    frekuensi = snapshot.value.toString()
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
    }


    private fun sendHistoryToFirestore() {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val date = current.format(formatter)

        val formatTime = DateTimeFormatter.ofPattern("HH:mm:ss")
        val time = current.format(formatTime)

        val data = hashMapOf(
            "waktu" to "$date $time",
            "daya" to daya,
            "arus" to arus,
            "tegangan" to tegangan,
            "frekuensi" to frekuensi,
            "suhu" to listOf(
                90, 89, 89, 79, 89, 90
            )
        )

        fire.collection("history")
            .add(data)
            .addOnSuccessListener { result ->
                Log.d("dataCollection", result.toString())
            }
    }


}