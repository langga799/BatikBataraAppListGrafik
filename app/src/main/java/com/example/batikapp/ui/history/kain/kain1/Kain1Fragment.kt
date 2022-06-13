package com.example.batikapp.ui.history.kain.kain1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.batikapp.databinding.FragmentKain1Binding
import com.example.batikapp.model.Riwayat
import com.google.firebase.database.*
import com.langga.batikapp.model.RiwayatKain1

class Kain1Fragment : Fragment() {

    private lateinit var binding: FragmentKain1Binding
    private lateinit var databaseReference: DatabaseReference
    private lateinit var listRiwayat: ArrayList<Riwayat>
    lateinit var listSuhu: ArrayList<RiwayatKain1>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKain1Binding.inflate(layoutInflater,
            container,
            false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listRiwayat = arrayListOf<Riwayat>()
        listSuhu = arrayListOf()
        databaseReference = FirebaseDatabase.getInstance().getReference("riwayat_kain_1")


        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (kain1 in snapshot.children) {

                        for (suhu in kain1.child("suhu").children) {
                            Log.d("kain11", suhu.toString())
//                           val riwayatKain1 = suhu.getValue(RiwayatKain1().id1.suhu!!)
//                            listSuhu.add(riwayatKain1!!)


                        }
                        Log.d("kain1", kain1.toString())
                        val riwayat = kain1.getValue(Riwayat::class.java)
                        if (riwayat != null) {
                            listRiwayat.add(riwayat)
                        }
                    }

                    setupRecycler(listRiwayat)

                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })


    }

    private fun setupRecycler(data: ArrayList<Riwayat>) {
        binding.rvHistoryKain1.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvHistoryKain1.adapter = Kain1Adapter(data)
        binding.rvHistoryKain1.setHasFixedSize(true)
    }


}