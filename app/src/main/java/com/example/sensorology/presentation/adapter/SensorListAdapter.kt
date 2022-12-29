package com.example.sensorology.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.sensorology.R
import com.example.sensorology.data.SensorModel
import com.example.sensorology.data.utils.OnClick

class SensorListAdapter(val sensors: List<SensorModel>, val onClick: OnClick) :
    Adapter<SensorListAdapter.SensorVH>() {
    class SensorVH(view: View) : ViewHolder(view) {

        val imageView = view.findViewById<ImageView>(R.id.image)
        val name = view.findViewById<TextView>(R.id.name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SensorVH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sensor_name_layout, parent, false)
        return SensorVH(view)
    }

    override fun onBindViewHolder(holder: SensorVH, position: Int) {
        val sensor = sensors[position]
        holder.name.text = sensor.name
        holder.imageView.setImageResource(sensor.image)

        holder.imageView.rootView.setOnClickListener {
            onClick.onSensorClicked(sensor)
        }

    }

    override fun getItemCount(): Int {
        return sensors.size
    }
}