package com.langga.batikapp.ui.history

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class AdapterTabHistory(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {

    private var fragment = ArrayList<Fragment>()

    fun addFragment(listFragment: ArrayList<Fragment>){
        fragment.clear()
        fragment.addAll(listFragment)
    }

    override fun getItemCount(): Int {
        return fragment.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragment[position]
    }
}