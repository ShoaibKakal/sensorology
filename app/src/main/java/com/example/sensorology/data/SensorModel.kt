package com.example.sensorology.data

import androidx.annotation.DrawableRes
import com.example.sensorology.R

data class SensorModel(@DrawableRes val image: Int, val name: String)

val sensors = listOf(
    SensorModel(R.drawable.accelerometer, "Accelerometer"),
    SensorModel(R.drawable.air_pressure, "Air Pressure"),
    SensorModel(R.drawable.ambient_temperature, "Ambient Temperature"),
    SensorModel(R.drawable.gravity, "Gravity"),
    SensorModel(R.drawable.gyroscope, "Gyroscope"),
    SensorModel(R.drawable.humidity, "Humidity"),
    SensorModel(R.drawable.light_level, "Light Level"),
    SensorModel(R.drawable.magnetic_field, "Magnetic Field"),
    SensorModel(R.drawable.mobile_temperature, "Device Temperature"),
    SensorModel(R.drawable.orientation, "Orientation"),
    SensorModel(R.drawable.proximity, "Proximity"),
    SensorModel(R.drawable.rotation_vector, "Rotation Vector"),
    SensorModel(R.drawable.step_detector, "Step Detector"),
)