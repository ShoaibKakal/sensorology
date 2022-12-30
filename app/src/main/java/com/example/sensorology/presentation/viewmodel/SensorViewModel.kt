package com.example.sensorology.presentation.viewmodel

import android.hardware.SensorEvent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.sensorology.data.repository.SensorRepo
import kotlinx.coroutines.launch

class SensorViewModel(private val sensorRepo: SensorRepo) : ViewModel() {


    private var _accelerometer = MutableLiveData<SensorEvent>()
    val accelerometer = _accelerometer

    fun setupSensor(sensorType: Int) {
        viewModelScope.launch {
            sensorRepo.setupSensor(sensorType)
        }
        viewModelScope.launch {
            sensorRepo.sensorEvent.collect {
                _accelerometer.value = it
            }
        }
    }

    fun unregisterSensor() {
        sensorRepo.unregisterSensor()
    }

    fun registerSensor() {
        sensorRepo.registerSensor()
    }


    class Factory(
        private val sensorRepo: SensorRepo,
    ) :
        ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(SensorViewModel::class.java)) {
                SensorViewModel(sensorRepo) as T
            } else {
                throw IllegalArgumentException("Unknown ViewModel Class")
            }
        }
    }

}