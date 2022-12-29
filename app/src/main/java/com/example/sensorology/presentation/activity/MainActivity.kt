package com.example.sensorology.presentation.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sensorology.data.SensorModel
import com.example.sensorology.data.sensors
import com.example.sensorology.data.utils.MYSENSOR
import com.example.sensorology.data.utils.OnClick
import com.example.sensorology.databinding.ActivityMainBinding
import com.example.sensorology.presentation.adapter.SensorListAdapter

class MainActivity : AppCompatActivity(), OnClick {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.adapter = SensorListAdapter(sensors, this)

    }

    override fun onSensorClicked(sensor: SensorModel) {
        val intent = Intent(this, SensorDetailActivity::class.java)
        intent.putExtra(MYSENSOR, sensor)
        startActivity(intent)
    }
}