package com.example.batikapp.ui.history

import android.content.Context
import android.graphics.Color
import androidx.core.content.ContextCompat
import com.example.batikapp.R
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

object Grafik {

    fun setGrafik(
        context: Context,
        record: ArrayList<Entry>,
        lineChart: LineChart,
    ) {

        // Style Grafik
        val lineDataSetRecord = LineDataSet(record, "Suhu")
        lineDataSetRecord.setCircleColor(ContextCompat.getColor(context, R.color.teal_700))
        lineDataSetRecord.color = ContextCompat.getColor(context, R.color.teal_700)
        lineDataSetRecord.lineWidth = 1.5F
        lineDataSetRecord.setDrawCircles(false)
        lineDataSetRecord.setDrawFilled(true)
        lineDataSetRecord.mode = LineDataSet.Mode.CUBIC_BEZIER
        lineDataSetRecord.valueTextSize = 10F
        lineDataSetRecord.valueTextColor = Color.BLACK
        lineDataSetRecord.circleHoleColor = ContextCompat.getColor(context, R.color.teal_700)

        // behavior grafik
        lineChart.setNoDataTextColor(Color.BLACK)
        lineChart.setDrawBorders(true)
        lineChart.isScaleYEnabled = false
        lineChart.isDoubleTapToZoomEnabled = false
        lineChart.description.text = ""
        lineChart.data = LineData(lineDataSetRecord)
        lineChart.animateXY(100, 10)
        lineChart.xAxis.valueFormatter = XAxisFormatter()
        lineChart.axisRight.isEnabled = false

    }
}