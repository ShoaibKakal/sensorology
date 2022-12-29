package com.example.sensorology.presentation.activity

import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.sensorology.data.SensorModel
import com.example.sensorology.data.repository.SensorRepo
import com.example.sensorology.data.utils.DrawGraph
import com.example.sensorology.data.utils.MYSENSOR
import com.example.sensorology.data.utils.TAG
import com.example.sensorology.databinding.ActivitySensorDetailBinding
import com.example.sensorology.presentation.viewmodel.SensorViewModel

class SensorDetailActivity : AppCompatActivity() {

    private val binding: ActivitySensorDetailBinding by lazy {
        ActivitySensorDetailBinding.inflate(layoutInflater)
    }
    private var pointsPlotted = 0
    private val sensorViewModel: SensorViewModel by viewModels {
        SensorViewModel.Factory(SensorRepo(getSystemService(SENSOR_SERVICE) as SensorManager))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val result = intent.getSerializableExtra(MYSENSOR) as SensorModel
        Toast.makeText(this, result.name, Toast.LENGTH_SHORT).show()

        val xAxisGraph = DrawGraph(binding.xGraph)
        val yAxisGraph = DrawGraph(binding.yGraph)
        val zAxisGraph = DrawGraph(binding.zGraph)
        xAxisGraph.setupGraph()
        yAxisGraph.setupGraph()
        zAxisGraph.setupGraph()

        sensorViewModel.setupSensor(Sensor.TYPE_PRESSURE)
        sensorViewModel.accelerometer.observe(this) {
            Log.d(TAG, "onCreate: ${it.values[0]}")
//            pointsPlotted++
//            xAxisGraph.updateGraph(pointsPlotted++, it.values[0].toDouble())
//            yAxisGraph.updateGraph(pointsPlotted++, it.values[1].toDouble())
//            zAxisGraph.updateGraph(pointsPlotted++, it.values[2].toDouble())
        }

    }
}