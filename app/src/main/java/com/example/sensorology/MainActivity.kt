package com.example.sensorology

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sensorology.data.sensors
import com.example.sensorology.databinding.ActivityMainBinding
import com.example.sensorology.presentation.adapters.SensorListAdapter

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.recyclerView.adapter = SensorListAdapter(sensors)

//        binding.btnAccelerometer.setOnClickListener {
//            navigate(SENSOR.ACCELEROMETER)
//        }
//        binding.btnAmbientTemperature.setOnClickListener {
//            navigate(SENSOR.AMBIENT_TEMPERATURE)
//        }
//        binding.btnDeviceTemperature.setOnClickListener {
//            navigate(SENSOR.DEVICE_TEMPERATURE)
//        }
//        binding.btnGravity.setOnClickListener {
//            navigate(SENSOR.GRAVITY)
//        }
//        binding.btnGyroscope.setOnClickListener {
//            navigate(SENSOR.GYROSCOPE)
//        }
//        binding.btnLinearAcceleration.setOnClickListener {
//            navigate(SENSOR.LINEAR_ACCELERATION)
//        }
//        binding.btnLight.setOnClickListener {
//            navigate(SENSOR.LIGHT)
//        }
//        binding.btnMagneticField.setOnClickListener {
//            navigate(SENSOR.MAGNETIC_FIELD)
//        }
//        binding.btnOrientation.setOnClickListener {
//            navigate(SENSOR.ORIENTATION)
//        }
//        binding.btnProximity.setOnClickListener {
//            navigate(SENSOR.PROXIMITY)
//        }
//        binding.btnPressure.setOnClickListener {
//            navigate(SENSOR.PRESSURE)
//        }
//        binding.btnRotationVector.setOnClickListener {
//            navigate(SENSOR.ROTATION_VECTOR)
//        }
//        binding.btnRelativeHumidity.setOnClickListener {
//            navigate(SENSOR.RELATIVE_HUMIDITY)
//        }
//        binding.btnStepDetector.setOnClickListener {
//            navigate(SENSOR.STEP_DETECTOR)
//        }
    }

    private fun navigate(sensor: SENSOR) {
        val intent = Intent(this, SensorDetailActivity::class.java)
        intent.putExtra(sensor)
        startActivity(intent)
    }
}