package com.example.batikapp.ui.history.kain.kain2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.batikapp.model.Riwayat
import com.example.batikapp.databinding.ItemViewRiwayatBinding


class Kain2Adapter(private val kain1: ArrayList<Riwayat>) :
    RecyclerView.Adapter<Kain2Adapter.Kain2Holder>() {

    inner class Kain2Holder(val binding: ItemViewRiwayatBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(riwayat: Riwayat) {
            binding.tvSuhu.text = riwayat.suhu.toString()
            binding.tvTanggal.text = riwayat.tanggal
            binding.tvArus.text = riwayat.arus.toString()
            binding.tvDaya.text = riwayat.daya.toString()
            binding.tvTegangan.text = riwayat.tegangan.toString()
            binding.tvFrekuensi.text = riwayat.suhu.toString()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Kain2Holder {
        return Kain2Holder(ItemViewRiwayatBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: Kain2Holder, position: Int) {
        holder.bind(kain1[position])
    }

    override fun getItemCount(): Int = kain1.size
}