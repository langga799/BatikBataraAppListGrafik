package com.example.batikapp.ui.history.kain.kain1

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.batikapp.R
import com.example.batikapp.databinding.ItemViewBinding
import com.example.batikapp.model.ItemHistory

var listGrafik = ArrayList<Int>()

class Kain1Adapter() : RecyclerView.Adapter<Kain1Adapter.Kain1ViewHolder>() {

    private val listData = ArrayList<ItemHistory>()

    init {
        Log.d("history====", listData.toString())
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addAll(data: ArrayList<ItemHistory>) {
        listData.addAll(data)
        notifyDataSetChanged()
    }

    inner class Kain1ViewHolder(private val binding: ItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(history: ItemHistory) {
            binding.apply {
                tvArus.text = history.arus
                tvDaya.text = history.daya
                tvTegangan.text = history.tegangan
                tvFrekuensi.text = history.frekuensi
                tvTanggal.text = history.waktu
            }

        }

        fun bindSuhu(itemSuhu: ItemHistory) {
            listGrafik.clear()
            for (data in itemSuhu.suhu) {
                val suhu = data.toString().toInt()
                listGrafik.add(suhu)
            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Kain1ViewHolder {
        return Kain1ViewHolder(ItemViewBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: Kain1ViewHolder, position: Int) {
        holder.bind(listData[position])

        holder.bindSuhu(listData[position])

        val childAdapter1 = ChildAdapter1()
        val rv = holder.itemView.findViewById<RecyclerView>(R.id.child_recycler_view)
        rv.apply {
            layoutManager =
                LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
            adapter = childAdapter1
            setHasFixedSize(true)
        }


    }

    override fun getItemCount(): Int {
        return listData.size
    }

}