package com.example.batikapp.ui.history.kain.kain1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.batikapp.model.Riwayat
import com.example.batikapp.databinding.ItemViewBinding

class Kain1Adapter(private val kain1: ArrayList<Riwayat>) :
    RecyclerView.Adapter<Kain1Adapter.Kain1Holder>() {

    inner class Kain1Holder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(riwayat: Riwayat) {
            binding.tvSuhuField.text = riwayat.suhu.toString()
            binding.tvTanggal.text = riwayat.tanggal
            binding.tvArus.text = riwayat.arus.toString()
            binding.tvDaya.text = riwayat.daya.toString()
            binding.tvTegangan.text = riwayat.tegangan.toString()
            binding.tvFrekuensi.text = riwayat.suhu.toString()

//            val suhu = RiwayatKain1().id1?.suhu!!
//            for (s in suhu.indices){
//                Log.d("suhukain", s.toString())
//            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Kain1Holder {
        return Kain1Holder(ItemViewBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: Kain1Holder, position: Int) {
        holder.bind(kain1[position])
    }

    override fun getItemCount(): Int = kain1.size
}