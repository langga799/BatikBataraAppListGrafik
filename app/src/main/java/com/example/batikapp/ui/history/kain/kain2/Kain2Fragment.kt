package com.example.batikapp.ui.history.kain.kain2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.batikapp.databinding.FragmentKain2Binding
import com.example.batikapp.model.Riwayat
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class Kain2Fragment : Fragment() {

    private lateinit var binding: FragmentKain2Binding
    private lateinit var databaseReference: DatabaseReference
    private lateinit var listRiwayat: ArrayList<Riwayat>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentKain2Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        databaseReference = Firebase.database.reference
        listRiwayat = arrayListOf()

        val reference = databaseReference.child("riwayat_kain_2")
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (riwayat in snapshot.children) {
                        val data = riwayat.getValue(Riwayat::class.java)
                        listRiwayat.add(data!!)
                    }
                    setupRecycler(listRiwayat)


                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(requireActivity(), error.message, Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun setupRecycler(data: ArrayList<Riwayat>) {
        val adapter = Kain2Adapter(data)
        binding.rvHistoryKain2.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvHistoryKain2.adapter = adapter
        binding.rvHistoryKain2.setHasFixedSize(true)
    }
}