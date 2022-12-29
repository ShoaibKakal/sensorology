package com.example.sensorology.data.utils

import com.example.sensorology.data.SensorModel

interface OnClick {
    fun onSensorClicked(sensor: SensorModel)
}