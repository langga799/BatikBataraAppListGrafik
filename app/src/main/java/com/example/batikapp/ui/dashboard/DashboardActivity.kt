package com.example.batikapp.ui.dashboard

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.batikapp.databinding.ActivityDashboardBinding
import com.example.batikapp.service.CustomNotification
import com.example.batikapp.service.CustomNotificationBatik
import com.example.batikapp.ui.berat.MonitoringBeratActivity
import com.example.batikapp.ui.control.ControlActivity
import com.example.batikapp.ui.history.HistoryMonitoringActivity
import com.example.batikapp.ui.listrik.MonitoringListrikActivity
import com.example.batikapp.ui.suhu.MonitoringSuhuActivity
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
class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var database: DatabaseReference
    private lateinit var notif: CustomNotification
    private lateinit var fire: FirebaseFirestore


    // Creating History
    private var arus = ""
    private var daya = ""
    private var tegangan = ""
    private var frekuensi = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        notif = CustomNotification()
        database = Firebase.database.reference
        fire = Firebase.firestore


        getDataDaya()
        getDataArus()
        getDataTegangan()
        getDataFrekuensi()


        checkNotifKain1()
        checkNotifKain2()
        checkNotifKain3()
        checkNotifKain4()
        checkNotifKain5()

        navigation()

    }


    private fun checkNotifKain1() {
        binding.alertWarning.visibility = View.INVISIBLE
        database.child("berat").child("kain_1")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.value.toString().toInt() < 200) {
                        binding.alertWarning.visibility = View.VISIBLE
                        notif.sendNotification1(this@DashboardActivity, "Kain 1 sudah kering")
                        sendHistoryToFirestore1()
                        Log.d("data", "Kain 1 sudah kering")
                    } else {
                        binding.alertWarning.visibility = View.GONE
                    }
                }

                override fun onCancelled(error: DatabaseError) {}

            })

    }


    private fun checkNotifKain2() {
        binding.alertWarning.visibility = View.INVISIBLE
        database.child("berat").child("kain_2")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.value.toString().toInt() < 200) {
                        binding.alertWarning.visibility = View.VISIBLE
                        notif.sendNotification2(this@DashboardActivity, "Kain 2 sudah kering")
                        Log.d("data", "Kain 2 sudah kering")
                        sendHistoryToFirestore2()
                    } else {
                        binding.alertWarning.visibility = View.GONE
                    }
                }

                override fun onCancelled(error: DatabaseError) {}

            })
    }


    private fun checkNotifKain3() {
        binding.alertWarning.visibility = View.INVISIBLE
        database.child("berat").child("kain_3")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.value.toString().toInt() < 200) {
                        binding.alertWarning.visibility = View.VISIBLE
                        notif.sendNotification3(this@DashboardActivity, "Kain 3 sudah kering")
                        Log.d("data", "Kain 3 sudah kering")
                        sendHistoryToFirestore3()
                    } else {
                        binding.alertWarning.visibility = View.GONE
                    }
                }

                override fun onCancelled(error: DatabaseError) {}

            })
    }


    private fun checkNotifKain4() {
        binding.alertWarning.visibility = View.INVISIBLE
        database.child("berat").child("kain_4")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.value.toString().toInt() < 200) {
                        binding.alertWarning.visibility = View.VISIBLE
                        notif.sendNotification4(this@DashboardActivity, "Kain 4 sudah kering")
                        Log.d("data", "Kain 4 sudah kering")
                        sendHistoryToFirestore4()
                    } else {
                        binding.alertWarning.visibility = View.GONE
                    }
                }

                override fun onCancelled(error: DatabaseError) {}

            })

    }


    private fun checkNotifKain5() {
        binding.alertWarning.visibility = View.INVISIBLE
        database.child("berat").child("kain_5")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.value.toString().toInt() < 200) {
                        binding.alertWarning.visibility = View.VISIBLE
                        notif.sendNotification5(this@DashboardActivity, "Kain 5 sudah kering")
                        Log.d("data", "Kain 5 sudah kering")
                        sendHistoryToFirestore5()
                    } else {
                        binding.alertWarning.visibility = View.GONE
                    }
                }

                override fun onCancelled(error: DatabaseError) {}

            })

    }


    /*
    * ==================================== Creating History =======================================
    */


    private fun getDataDaya() {
        database.child("listrik").child("daya")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    daya = snapshot.value.toString()
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
    }

    private fun getDataArus() {
        database.child("listrik").child("arus")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    arus = snapshot.value.toString()
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
    }

    private fun getDataTegangan() {
        database.child("listrik").child("tegangan")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    tegangan = snapshot.value.toString()
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
    }

    private fun getDataFrekuensi() {
        database.child("listrik").child("frekuensi")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    frekuensi = snapshot.value.toString()
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
    }


    private fun sendHistoryToFirestore1() {
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

    private fun sendHistoryToFirestore2() {
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

        fire.collection("history2")
            .add(data)
            .addOnSuccessListener { result ->
                Log.d("dataCollection", result.toString())
            }
    }

    private fun sendHistoryToFirestore3() {
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

        fire.collection("history3")
            .add(data)
            .addOnSuccessListener { result ->
                Log.d("dataCollection", result.toString())
            }
    }

    private fun sendHistoryToFirestore4() {
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

        fire.collection("history4")
            .add(data)
            .addOnSuccessListener { result ->
                Log.d("dataCollection", result.toString())
            }
    }

    private fun sendHistoryToFirestore5() {
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

        fire.collection("history5")
            .add(data)
            .addOnSuccessListener { result ->
                Log.d("dataCollection", result.toString())
            }
    }



    // Navigation ==================================================================================
    private fun navigation() {
        binding.apply {
            toPageTemperature.setOnClickListener {
                startActivity(Intent(this@DashboardActivity, MonitoringSuhuActivity::class.java))
            }
            toPageWeight.setOnClickListener {
                startActivity(Intent(this@DashboardActivity, MonitoringBeratActivity::class.java))
            }
            toPageElectric.setOnClickListener {
                startActivity(Intent(this@DashboardActivity, MonitoringListrikActivity::class.java))
            }
            toPageHistory.setOnClickListener {
                startActivity(Intent(this@DashboardActivity, HistoryMonitoringActivity::class.java))
            }
            toPageControl.setOnClickListener {
                startActivity(Intent(this@DashboardActivity, ControlActivity::class.java))
            }
        }

    }
}