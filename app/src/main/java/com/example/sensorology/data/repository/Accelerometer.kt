package com.example.sensorology.data.repository

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

class Accelerometer(private val sensorManager: SensorManager) : SensorEventListener {

    private val _accelerometer = MutableSharedFlow<SensorEvent>(replay = 1)
    val accelerometer: SharedFlow<SensorEvent> = _accelerometer


    init {
        val sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        sensor?.let {
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onSensorChanged(sensorEvent: SensorEvent?) {
        sensorEvent?.let {
            _accelerometer.tryEmit(it)
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {}

}