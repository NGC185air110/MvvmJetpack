package com.example.mvvmjetpack

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import com.example.mvvmjetpack.databinding.ActivityMain11Binding


/**
 * title：
 * description：
 * author：dinglicheng on 2022/9/6 11:23
 */
class MainActivity11 : BaseActivity<ActivityMain11Binding>(ActivityMain11Binding::inflate) {

    private var sm: SensorManager? = null

    //需要两个Sensor
    private var aSensor: Sensor? = null
    private var mSensor: Sensor? = null
    var accelerometerValues = FloatArray(3)
    var magneticFieldValues = FloatArray(3)
    private val TAG = "sensor"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sm = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        aSensor = sm!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        mSensor = sm!!.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)

        sm!!.registerListener(myListener, aSensor, SensorManager.SENSOR_DELAY_NORMAL)
        sm!!.registerListener(myListener, mSensor, SensorManager.SENSOR_DELAY_NORMAL)

        calculateOrientation()
    }

    override fun onPause() {
        sm?.unregisterListener(myListener)
        super.onPause()
    }

    private val myListener: SensorEventListener = object : SensorEventListener {
        override fun onSensorChanged(sensorEvent: SensorEvent) {
            if (sensorEvent.sensor.type == Sensor.TYPE_MAGNETIC_FIELD) magneticFieldValues =
                sensorEvent.values
            if (sensorEvent.sensor.type == Sensor.TYPE_ACCELEROMETER) accelerometerValues =
                sensorEvent.values
            calculateOrientation()
        }

        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {}
    }

    private fun calculateOrientation() {
        val values = FloatArray(3)
        val ret = FloatArray(9)
        SensorManager.getRotationMatrix(ret, null, accelerometerValues, magneticFieldValues)
        SensorManager.getOrientation(ret, values)

        // 要经过一次数据格式的转换，转换为度
        values[0] = Math.toDegrees(values[0].toDouble()).toFloat()
        viewBinding.textView.text = values[0].toString()
        values[1] = Math.toDegrees(values[1].toDouble()).toFloat()
        viewBinding.textView2.text = values[1].toString()
        values[2] = Math.toDegrees(values[2].toDouble()).toFloat()
        viewBinding.textView3.text = values[2].toString()
    }
}