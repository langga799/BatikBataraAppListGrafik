package com.example.batikapp.ui.history.kain.kain3

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.batikapp.databinding.FragmentKain3Binding
import com.example.batikapp.model.ItemHistory
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlin.coroutines.CoroutineContext


class Kain3Fragment : Fragment() {

    private lateinit var binding: FragmentKain3Binding
    private lateinit var fire: FirebaseFirestore
    private val listData = mutableListOf<ItemHistory>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKain3Binding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fire = Firebase.firestore

        fire.collection("history").get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val suhu = document.get("suhu") as List<*>
                    val arus = document.get("arus")
                    val daya = document.get("daya")
                    val tegangan = document.get("tegangan")
                    val frekuensi = document.get("frekuensi")
                    val waktu = document.get("waktu")


                    listData.add(ItemHistory(
                        waktu.toString(),
                        daya.toString(),
                        arus.toString(),
                        tegangan.toString(),
                        frekuensi.toString(),
                        suhu
                    ))

                    Log.d("collection", listData.toString())

                }
                Log.d("colleddction", listData.toString())
                setupRecyclerView(listData)
            }

        Log.d("collection=======", listData.toString())

        setupRecyclerView(listData)

    }

    private fun setupRecyclerView(data : MutableList<ItemHistory>) {
        val adapter = Kain3Adapter(data)
        binding.rvHistoryKain3.adapter = adapter
        binding.rvHistoryKain3.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvHistoryKain3.setHasFixedSize(true)

        Log.d("data-kain3", listData.toString())
    }
}