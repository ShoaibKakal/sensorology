package com.example.sensorology.data.repository

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

class AmbientTemperature(private val sensorManager: SensorManager) : SensorEventListener {
    private val _ambientTemperature = MutableSharedFlow<SensorEvent>(replay = 1)
    val ambientTemperature: SharedFlow<SensorEvent> = _ambientTemperature

    init {
        val sensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)
        sensor?.let {
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onSensorChanged(sensorEvent: SensorEvent?) {
        sensorEvent?.let {
            _ambientTemperature.tryEmit(it)
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {}
}