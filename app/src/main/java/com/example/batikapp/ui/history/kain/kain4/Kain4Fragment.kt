package com.example.batikapp.ui.history.kain.kain4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.batikapp.databinding.FragmentKain4Binding
import com.example.batikapp.model.ItemHistory
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class Kain4Fragment : Fragment() {

    private lateinit var binding: FragmentKain4Binding
    private lateinit var fire: FirebaseFirestore
    private val kain4Adapter = Kain4Adapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKain4Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fire = Firebase.firestore

        binding.progressBar.visibility = View.VISIBLE
        fire.collection("history4").orderBy("waktu", Query.Direction.DESCENDING).get()
            .addOnSuccessListener { result ->
                binding.progressBar.visibility = View.GONE
                for (document in result) {
                    val suhu = document.get("suhu") as List<*>
                    val arus = document.get("arus")
                    val daya = document.get("daya")
                    val tegangan = document.get("tegangan")
                    val frekuensi = document.get("frekuensi")
                    val waktu = document.get("waktu")


                    kain4Adapter.addAll(
                        arrayListOf(ItemHistory(
                            waktu.toString(),
                            daya.toString(),
                            arus.toString(),
                            tegangan.toString(),
                            frekuensi.toString(),
                            suhu
                        )))

                }
            }


        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        binding.rvHistoryKain4.adapter = kain4Adapter
        binding.rvHistoryKain4.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvHistoryKain4.setHasFixedSize(true)
    }
}