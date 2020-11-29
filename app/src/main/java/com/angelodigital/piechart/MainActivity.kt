package com.angelodigital.piechart

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupPieChart()
    }

    private fun setupPieChart() {
        // Setup Pie Entries
        val pieEntries = arrayListOf<PieEntry>()
        pieEntries.add(PieEntry(30.0f))
        pieEntries.add(PieEntry(40.0f))
        pieEntries.add(PieEntry(60.0f))

        // Setup Pie Chart Animation
        pieChart.animateXY(1000, 1000) // This 1000 is time that how much time piechart chreated

        // Setup PicChart Colors
        val pieDataSet = PieDataSet(pieEntries, "This is Pie Chart Label")
        pieDataSet.setColors(
                resources.getColor(R.color.colorPrimary),
                resources.getColor(R.color.colorPrimaryDark),
                resources.getColor(R.color.colorAccent)
        )

        // Setup Pie Data Set in PieData
        val pieData = PieData(pieDataSet)
        pieData.setDrawValues(true)     // This is for values in pie entries.

        // Setup PieCharts Values and Ui
        pieChart.description.isEnabled = true   // This is pie chart description that in below entries.
        pieChart.description.text = "Pic Chart For TechnoFolk"

        // This is for center text
        pieChart.centerText = "Hello Pic Chart"
        pieChart.setCenterTextSize(15f)
        pieChart.setCenterTextColor(resources.getColor(android.R.color.black))

        // This is because of tags of pie chart entries.
        pieChart.legend.isEnabled = true


        // this is for space that is at the center of the pie chart.
        pieChart.isDrawHoleEnabled = true
        pieChart.holeRadius = 75f

        // Finally Setup the add Values in PieChart.
        pieChart.data = pieData
    }
}