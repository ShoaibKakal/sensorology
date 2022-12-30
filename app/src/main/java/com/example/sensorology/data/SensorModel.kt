package com.example.sensorology.data

import android.hardware.Sensor
import androidx.annotation.DrawableRes
import com.example.sensorology.R

data class SensorModel(
    @DrawableRes val image: Int,
    val name: String,
    val sensorType: Int,
    val measurementUnit: String,
    val axis: List<String>,
    val specialText: String? = null,
    val info: String
) :
    java.io.Serializable

val sensors = listOf(
    SensorModel(
        R.drawable.accelerometer,
        "Linear Accelerometer",
        Sensor.TYPE_LINEAR_ACCELERATION,
        "m/s^2",
        arrayListOf(
            "Acceleration force along the X axis (excluding gravity).",
            "Acceleration force along the Y axis (excluding gravity).",
            "Acceleration force along the Z axis (excluding gravity)."
        ),
        info = "The linear acceleration sensor provides you with a three-dimensional vector representing acceleration along each device axis, excluding gravity. You can use this value to perform gesture detection. The value can also serve as input to an inertial navigation system, which uses dead reckoning. "
    ),
    SensorModel(
        R.drawable.air_pressure,
        "Air Pressure",
        Sensor.TYPE_PRESSURE,
        "hPa or mbar",
        arrayListOf("Ambient air pressure."),
        info = "The raw data you acquire from the light, pressure, and temperature sensors usually requires no calibration, filtering, or modification, which makes them some of the easiest sensors to use."

    ),
    SensorModel(
        R.drawable.ambient_temperature,
        "Ambient Temperature",
        Sensor.TYPE_AMBIENT_TEMPERATURE,
        "°C",
        arrayListOf("Ambient air temperature."),
        "Implementations vary from device to device. This sensor was deprecated in Android 4.0 (API Level 14)",
        info = "The raw data you acquire from the light, pressure, and temperature sensors usually requires no calibration, filtering, or modification, which makes them some of the easiest sensors to use."

    ),
    SensorModel(
        R.drawable.gravity,
        "Gravity",
        Sensor.TYPE_GRAVITY,
        "m/s^2",
        arrayListOf(
            "Force of gravity along the X axis.",
            "Force of gravity along the Y axis.",
            "Force of gravity along the Z axis."
        ),
        info = "The gravity sensor provides a three dimensional vector indicating the direction and magnitude of gravity. Typically, this sensor is used to determine the device's relative orientation in space."
    ),
    SensorModel(
        R.drawable.gyroscope, "Gyroscope", Sensor.TYPE_GYROSCOPE, "rad/s", arrayListOf(
            "Rate of rotation around the X axis",
            "Rate of rotation around the Y axis",
            "Rate of rotation around the Z axis",
        ),
        info = "A gyroscope sensor is a device that is used to measure and maintain the orientation and angular velocity of an object. This sensor is also known by various names such as Angular Rate Sensor or Angular Velocity Sensors."
    ),
    SensorModel(
        R.drawable.humidity,
        "Humidity",
        Sensor.TYPE_RELATIVE_HUMIDITY,
        "%",
        arrayListOf("Ambient relative humidity."),
        info = "You can acquire raw relative humidity data by using the humidity sensor the same way that you use the light, pressure, and temperature sensors. However, if a device has both a humidity sensor (TYPE_RELATIVE_HUMIDITY) and a temperature sensor (TYPE_AMBIENT_TEMPERATURE) you can use these two data streams to calculate the dew point and the absolute humidity."
    ),
    SensorModel(
        R.drawable.light_level,
        "Light Level",
        Sensor.TYPE_LIGHT,
        "lx",
        arrayListOf("Illuminance"),
        info = "The raw data you acquire from the light, pressure, and temperature sensors usually requires no calibration, filtering, or modification, which makes them some of the easiest sensors to use."
    ),
    SensorModel(
        R.drawable.magnetic_field, "Magnetic Field", Sensor.TYPE_MAGNETIC_FIELD, "μT", arrayListOf(
            "Geomagnetic field strength along the X axis.",
            "Geomagnetic field strength along the Y axis.",
            "Geomagnetic field strength along the Z axis."
        ),
        info = "The geomagnetic field sensor lets you monitor changes in the earth's magnetic field.\nThis sensor provides raw field strength data (in μT) for each of the three coordinate axes. Usually, you do not need to use this sensor directly. Instead, you can use the rotation vector sensor to determine raw rotational movement or you can use the accelerometer and geomagnetic field sensor in conjunction with the getRotationMatrix() method to obtain the rotation matrix and the inclination matrix. You can then use these matrices with the getOrientation() and getInclination() methods to obtain azimuth and geomagnetic inclination data."
    ),
    SensorModel(
        R.drawable.mobile_temperature,
        "Device Temperature",
        Sensor.TYPE_TEMPERATURE,
        "°C",
        arrayListOf("Device temperature"),
        "Implementations vary from device to device. This sensor was deprecated in Android 4.0 (API Level 14)",
        info = "The raw data you acquire from the light, pressure, and temperature sensors usually requires no calibration, filtering, or modification, which makes them some of the easiest sensors to use."

    ),
    SensorModel(
        R.drawable.orientation,
        "Orientation",
        Sensor.TYPE_ORIENTATION,
        "Degrees",
        arrayListOf(
            "Azimuth (angle around the Z-axis).",
            "Pitch (angle around the X-axis).",
            "Roll (angle around the Y-axis)."
        ),
        "This sensor was deprecated in Android 2.2 (API level 8), and this sensor type was deprecated in Android 4.4W (API level 20). The sensor framework provides alternate methods for acquiring device orientation, which are discussed in Compute the device's orientation.",
        info = "By computing a device's orientation, you can monitor the position of the device relative to the earth's frame of reference (specifically, the magnetic north pole). "
    ),
    SensorModel(
        R.drawable.proximity,
        "Proximity",
        Sensor.TYPE_PROXIMITY,
        "cm",
        arrayListOf("Distance from object."),
        "Some proximity sensors provide only binary values representing near and far",
        info = "The proximity sensor lets you determine how far away an object is from a device.\nThe proximity sensor is usually used to determine how far away a person's head is from the face of a handset device (for example, when a user is making or receiving a phone call). Most proximity sensors return the absolute distance, in cm, but some return only near and far values."
    ),
    SensorModel(
        R.drawable.rotation_vector,
        "Rotation Vector",
        Sensor.TYPE_ROTATION_VECTOR,
        "Unitless",
        arrayListOf(
            "Rotation vector component along the X axis (x * sin(θ/2)).",
            "Rotation vector component along the Y axis (y * sin(θ/2)).",
            "Rotation vector component along the Z axis (z * sin(θ/2)).",
        ),
        "The scalar component [((cos(θ/2)] is an optional value that's why is not implemented here.",
        info = "The rotation vector represents the orientation of the device as a combination of an angle and an axis, in which the device has rotated through an angle θ around an axis (x, y, or z)." +
                "\nX is defined as the vector product Y x Z. It is tangential to the ground at the device's current location and points approximately East." +
                "\nY is tangential to the ground at the device's current location and points toward the geomagnetic North Pole." +
                "\nZ points toward the sky and is perpendicular to the ground plane."
    ),
    SensorModel(
        R.drawable.step_detector,
        "Step Detector",
        Sensor.TYPE_STEP_DETECTOR,
        "Unitless",
        arrayListOf("Returns 1 if step is detected"),
        info = "The step detector sensor triggers an event each time the user takes a step. The latency is expected to be below 2 seconds."
    ),
)