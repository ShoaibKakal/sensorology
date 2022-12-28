package com.example.sensorology

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sensorology.databinding.ActivitySensorDetailBinding

class SensorDetailActivity : AppCompatActivity() {
    private val binding: ActivitySensorDetailBinding by lazy {
        ActivitySensorDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val result = intent.getEnumExtra<SENSOR>()
        Toast.makeText(this, "$result", Toast.LENGTH_SHORT).show()
    }
}