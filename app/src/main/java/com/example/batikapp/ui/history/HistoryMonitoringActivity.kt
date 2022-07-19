package com.example.batikapp.ui.history

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.batikapp.databinding.ActivityHistoryMonitoringBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.example.batikapp.ui.dashboard.DashboardActivity
import com.example.batikapp.ui.history.kain.kain1.Kain1Fragment
import com.example.batikapp.ui.history.kain.kain2.Kain2Fragment
import com.example.batikapp.ui.history.kain.kain3.Kain3Fragment
import com.example.batikapp.ui.history.kain.kain4.Kain4Fragment
import com.example.batikapp.ui.history.kain.kain5.Kain5Fragment

class HistoryMonitoringActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryMonitoringBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryMonitoringBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackToDashboard.setOnClickListener {
            startActivity(
                Intent(this, DashboardActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            finishAffinity()
        }

        setupTabLayout()

    }

    private fun setupTabLayout() {
        val adapter = AdapterTabHistory(this)
        val viewPager = binding.viewPager2
        viewPager.adapter = adapter
        viewPager.offscreenPageLimit = 1

        adapter.addFragment(
            arrayListOf(
                Kain1Fragment(),
                Kain2Fragment(),
                Kain3Fragment(),
                Kain4Fragment(),
                Kain5Fragment(),
            )
        )

        val tabTitle = arrayOf("Kain 1", "Kain 2", "Kain 3", "Kain 4", "Kain 5")

        TabLayoutMediator(
            binding.tabLayout, viewPager
        ) { tab, position ->
            tab.text = tabTitle[position]
        }.attach()
    }
}