package com.example.batikapp.ui.history.kain.kain3

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.batikapp.databinding.ItemViewBinding
import com.example.batikapp.model.History


class Kain3Adapter( private val context: Context) :
    RecyclerView.Adapter<Kain3Adapter.Kain3ViewHolder>() {

    init {
        Log.d("history====", listData.toString())
    }

    private var listPoint = arrayListOf<Int>()

    inner class Kain3ViewHolder(private val binding: ItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(history: History) {
            binding.apply {
                tvArus.text = history.arus
                tvDaya.text = history.daya
                tvTegangan.text = history.tegangan
                tvFrekuensi.text = history.frekuensi
                tvTanggal.text = history.waktu

//                for (suhu in history.suhu){
//                    val data = suhu.toString().toInt()
//                //    listPoint.add(data)
//                    listGrafik.add(ItemGrafik(data))
//                    Log.d("suhu1", listPoint.toString())
//                }
            }


            val data = history.suhu
            for (d in data){
                val item = d.toString().toInt()
                listPoint.add(item)
            }


            val adapter = ChildAdapter3(
                arrayListOf(
                    listOf(),
                    listOf(6,7,8)
                )
            )
            binding.apply {
                childRecyclerView.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
                childRecyclerView.adapter = adapter
                childRecyclerView.setHasFixedSize(true)
            }


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Kain3ViewHolder {
        return Kain3ViewHolder(ItemViewBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: Kain3ViewHolder, position: Int) {
        holder.bind(listData[position])


    }

    override fun getItemCount(): Int {
        return listData.size
    }

}

//                val record = ArrayList<Entry>()
//                val mutableData = mutableListOf<Float>()
//
//                for (j in listPoint.indices) {
//                    mutableData.add(listPoint[j].toFloat())
//                }
//
//                for ((x, y) in mutableData.indices.withIndex()) {
//                    record.add(Entry(x.toFloat(), mutableData[y]))
//                }
//
//
//                Grafik.setGrafik(context, record, binding.suhuKain1)