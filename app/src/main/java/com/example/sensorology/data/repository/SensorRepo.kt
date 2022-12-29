package com.example.sensorology.data.repository

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log
import com.example.sensorology.data.utils.TAG
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

class SensorRepo(private val sensorManager: SensorManager?) : SensorEventListener {

    private val _sensorEvent = MutableSharedFlow<SensorEvent>(replay = 1)
    val sensorEvent: SharedFlow<SensorEvent> = _sensorEvent

    private var sensor: Sensor? = null

    fun setupSensor(sensorType: Int) {
        try {
            sensor = sensorManager?.getDefaultSensor(sensorType)
            sensorManager?.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
            if (sensor == null) {
                Log.d(TAG, "setupSensor: Sensor Not Found")
            }
        } catch (e: Exception) {
            Log.d(TAG, "setupSensor: ${e.message}")
        }

    }


    override fun onSensorChanged(sensorEvent: SensorEvent?) {
        sensorEvent?.let {
            _sensorEvent.tryEmit(it)
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {}


}