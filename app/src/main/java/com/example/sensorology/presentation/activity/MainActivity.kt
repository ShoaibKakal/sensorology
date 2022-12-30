package com.example.sensorology.presentation.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.sensorology.data.SensorModel
import com.example.sensorology.data.sensors
import com.example.sensorology.data.utils.MYSENSOR
import com.example.sensorology.data.utils.OnClick
import com.example.sensorology.data.utils.PHYSICAL_ACTIVITY_REQUEST_CODE
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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getPermissionForStepCounterSensor()
        }
    }

    override fun onSensorClicked(sensor: SensorModel) {
        val intent = Intent(this, SensorDetailActivity::class.java)
        intent.putExtra(MYSENSOR, sensor)
        startActivity(intent)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun getPermissionForStepCounterSensor() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACTIVITY_RECOGNITION
            ) == PackageManager.PERMISSION_DENIED
        ) {
            //ask for permission
            requestPermissions(
                arrayOf(Manifest.permission.ACTIVITY_RECOGNITION),
                PHYSICAL_ACTIVITY_REQUEST_CODE
            );
        }
    }
}