package com.example.sensorology.data.utils

import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries

class DrawGraph(val graphView: GraphView) {

    val viewPort = graphView.viewport
    private var series = LineGraphSeries<DataPoint>(
        arrayOf()
    )

    fun setupGraph() {
        viewPort.setScrollableY(true)
        viewPort.setScrollableY(true)
        viewPort.isXAxisBoundsManual = true
        graphView.addSeries(series)

        //set manual X bounds
        graphView.viewport.apply {
            isYAxisBoundsManual = true
            setMinY(-50.0)
            setMaxY(50.0)
            isXAxisBoundsManual = true
            setMinX(50.0)
            setMaxX(50.0)
        }

        //enable scaling and scrolling
        graphView.viewport.apply {
            isScalable = true
            setScalableY(true)
            setScrollableY(true)
            isScrollable = true
        }

        graphView.addSeries(series)
    }

    fun updateGraph(pointsPlotted: Int, updateValue: Double) {

        series.appendData(DataPoint(pointsPlotted.toDouble(), updateValue), true, pointsPlotted)
        viewPort.setMaxX(pointsPlotted.toDouble())
        viewPort.setMinX(pointsPlotted.toDouble() - 200)

    }
}