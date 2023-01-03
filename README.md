# Sensorology
Sensorology allows users to view and interact with the various sensors on their device, utilizing GraphView to display the sensor data in real-time...



<p align="center">

<Img src="app/src/main/res/drawable/thumbnail.png" />

</p>


<p align="center">
<Img src="app/src/main/res/drawable/screenshot_1.png" height="500" />
<Img src="app/src/main/res/drawable/screenshot_4.png" height="500"/>
<Img src="app/src/main/res/drawable/screenshot_3.png" height="500"/>
</p>


  ### 13 Major Sensors Are Implemented
  Sensor | Type | Description | Common Uses 
--- | --- | --- | --- 
Linear Accelerometer | Software or Hardware | Measures the acceleration force in m/s2 that is applied to a device on all three physical axes (x, y, and z), excluding the force of gravity.	 | Monitoring acceleration along a single axis.
Gravity | Software of Hardware | Measures the force of gravity in m/s2 that is applied to a device on all three physical axes (x, y, z).	| Motion detection (shake, tilt, etc.).
Gyroscope | Hardware | Measures a device's rate of rotation in rad/s around each of the three physical axes (x, y, and z).	| Rotation detection (spin, turn, etc.).
Rotation Vector | Software or Hardware	| Measures the orientation of a device by providing the three elements of the device's rotation vector.	| Motion detection and rotation detection.
Step Detector | Software or Hardware | Returns 1 when step is detected	| For Healthcare apps like step counting.
Magnetic Field | Hardware | Measures the ambient geomagnetic field for all three physical axes (x, y, z) in μT.	| Creating a compass.
Air Pressure | Hardware | Measures the ambient air pressure in hPa or mbar.	| Monitoring air pressure changes.
Proximity | Hardware | Measures the proximity of an object in cm relative to the view screen of a device. This sensor is typically used to determine whether a handset is being held up to a person's ear.	| Phone position during a call.
Relative Humidity | Hardware | Measures the relative ambient humidity in percent (%).	| Monitoring dewpoint, absolute, and relative humidity.
Device Temperature | Hardware | Measures the temperature of the device in degrees Celsius (°C). This sensor implementation varies across devices and this sensor was replaced with the TYPE_AMBIENT_TEMPERATURE sensor in API Level 14	| Monitoring temperatures.
Light | Hardware | Measures the ambient light level (illumination) in lx.	| Controlling screen brightness.
Ambient Temperature | Hardware | Measures the ambient room temperature in degrees Celsius (°C). See note below.	| Monitoring air temperatures.
Orientation | Software | Measures degrees of rotation that a device makes around all three physical axes (x, y, z). As of API level 3 you can obtain the inclination matrix and rotation matrix for a device by using the gravity sensor and the geomagnetic field sensor in conjunction with the getRotationMatrix() method.	| Determining device position.



### Contributors

Thanks goes to these wonderful people:
<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore -->

<table>
  <tr>
      
  <td align="center"><a href="https://github.com/shoaibkakal"><img src="https://avatars1.githubusercontent.com/u/56650286?s=400&u=1e0ab7f2025a0cdcce8d6821b6a8d619577f2ae3&v=4"       width="100px;" alt="Shoaib Kakal"/><br /><sub><b>Shoaib Kakal</b></sub></a><br/></td>
  
  </tr>
</table>
