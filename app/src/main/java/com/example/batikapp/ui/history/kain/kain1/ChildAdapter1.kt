package com.example.batikapp.ui.history.kain.kain1import android.view.LayoutInflaterimport android.view.ViewGroupimport androidx.recyclerview.widget.RecyclerViewimport com.example.batikapp.Rimport com.example.batikapp.databinding.ChildItemGrafikBindingimport com.example.batikapp.ui.history.Grafikimport com.github.mikephil.charting.data.Entryclass ChildAdapter1 : RecyclerView.Adapter<ChildAdapter1.ChildViewHolder1>() {    inner class ChildViewHolder1(private val binding: ChildItemGrafikBinding) :        RecyclerView.ViewHolder(binding.root) {    }    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder1 {        return ChildViewHolder1(ChildItemGrafikBinding.inflate(LayoutInflater.from(parent.context),            parent,            false))    }    override fun onBindViewHolder(holder: ChildViewHolder1, position: Int) {        //     holder.bind(listGrafik[position])        val record = ArrayList<Entry>()        val mutableData = mutableListOf<Float>()        for (j in listGrafik.indices) {            mutableData.add(listGrafik[j].toFloat())        }        for ((x, y) in mutableData.indices.withIndex()) {            record.add(Entry(x.toFloat(), mutableData[y]))        }        Grafik.setGrafik(holder.itemView.context,            record,            holder.itemView.findViewById(R.id.grafik_suhu_kain))    }    override fun getItemCount(): Int {        return 1    }}