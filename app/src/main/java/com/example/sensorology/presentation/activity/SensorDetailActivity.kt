package com.example.sensorology.presentation.activity

import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.sensorology.R
import com.example.sensorology.data.SensorModel
import com.example.sensorology.data.repository.SensorRepo
import com.example.sensorology.data.utils.DrawGraph
import com.example.sensorology.data.utils.MYSENSOR
import com.example.sensorology.data.utils.TAG
import com.example.sensorology.databinding.ActivitySensorDetailBinding
import com.example.sensorology.presentation.viewmodel.SensorViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class SensorDetailActivity : AppCompatActivity() {

    private val binding: ActivitySensorDetailBinding by lazy {
        ActivitySensorDetailBinding.inflate(layoutInflater)
    }
    private lateinit var sensorManager: SensorManager
    private var pointsPlotted = 0
    private val sensorViewModel: SensorViewModel by viewModels {
        SensorViewModel.Factory(SensorRepo(sensorManager))
    }

    private var isSensorActive = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val sensorModel = intent.getSerializableExtra(MYSENSOR) as SensorModel

        binding.appBarTitle.text = sensorModel.name
        binding.btnControl.setOnClickListener {
            if (isSensorActive) {
                sensorViewModel.unregisterSensor()
                binding.btnControl.text = getString(R.string.start)
            } else {
                sensorViewModel.registerSensor()
                binding.btnControl.text = getString(R.string.stop)
            }
            isSensorActive = !isSensorActive
        }

        binding.imageInfo.setOnClickListener {
            infoDialogueBox(sensorModel)
        }
        val xAxisGraph = DrawGraph(binding.xGraph)
        val yAxisGraph = DrawGraph(binding.yGraph)
        val zAxisGraph = DrawGraph(binding.zGraph)
        xAxisGraph.setupGraph()
        yAxisGraph.setupGraph()
        zAxisGraph.setupGraph()
        xAxisGraph.graphView.gridLabelRenderer.verticalAxisTitle = sensorModel.measurementUnit


        if (isSensorAvailable(sensorModel.sensorType)) {
            binding.layoutSensorNotFound.isVisible = false
            binding.xCard.isVisible = true
            if (!sensorModel.specialText.isNullOrEmpty()) {
                binding.tvInfo.apply {
                    isVisible = true
                    text = sensorModel.specialText
                }
            }
        }
        binding.tvSensorNotFound.text = getString(R.string.sensor_not_found, sensorModel.name)

        sensorViewModel.setupSensor(sensorModel.sensorType)
        sensorViewModel.accelerometer.observe(this) {
            Log.d(TAG, "onCreate: size: ${it.values.size}")
            pointsPlotted++
            when (it.values.size) {
                1 -> {
                    binding.xCard.isVisible = true
                    xAxisGraph.updateGraph(pointsPlotted++, it.values[0].toDouble())
                    binding.xTitle.text = sensorModel.axis[0]
                    if (sensorModel.sensorType == Sensor.TYPE_STEP_DETECTOR) {
                        xAxisGraph.viewPort.setMaxY(2.0)
                        xAxisGraph.viewPort.setMinY(-2.0)
                    }
                }
                2 -> {
                    binding.xCard.isVisible = true
                    binding.yCard.isVisible = true
                    yAxisGraph.updateGraph(pointsPlotted++, it.values[1].toDouble())
                    zAxisGraph.updateGraph(pointsPlotted++, it.values[2].toDouble())
                    binding.xTitle.text = sensorModel.axis[0]
                    binding.yTitle.text = sensorModel.axis[1]

                }
                else -> {
                    binding.xCard.isVisible = true
                    binding.yCard.isVisible = true
                    binding.zCard.isVisible = true
                    xAxisGraph.updateGraph(pointsPlotted++, it.values[0].toDouble())
                    yAxisGraph.updateGraph(pointsPlotted++, it.values[1].toDouble())
                    zAxisGraph.updateGraph(pointsPlotted++, it.values[2].toDouble())
                    binding.xTitle.text = sensorModel.axis[0]
                    binding.yTitle.text = sensorModel.axis[1]
                    binding.zTitle.text = sensorModel.axis[2]

                }
            }
        }

    }

    private fun isSensorAvailable(sensorType: Int): Boolean {
        val sensor = sensorManager.getDefaultSensor(sensorType)
        Log.d(TAG, "isSensorAvailable: ${sensor != null} SENSOR: $sensorType")

        return sensor != null
    }

    override fun onResume() {
        super.onResume()
        sensorViewModel.registerSensor()
    }

    override fun onPause() {
        super.onPause()
        sensorViewModel.unregisterSensor()
    }


    private fun infoDialogueBox(sensorModel: SensorModel) {
        sensorViewModel.unregisterSensor()
        MaterialAlertDialogBuilder(this)
            .setTitle("Usage of ${sensorModel.name}")
            .setMessage(sensorModel.info)
            .setPositiveButton("Okay") { dialog, which ->
                dialog.dismiss()
                sensorViewModel.registerSensor()
            }
            .show()
    }
}