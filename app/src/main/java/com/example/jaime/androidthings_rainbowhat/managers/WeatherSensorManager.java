package com.example.jaime.androidthings_rainbowhat.managers;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.google.android.things.contrib.driver.bmx280.Bmx280SensorDriver;
import java.io.IOException;
import static android.content.Context.SENSOR_SERVICE;
import static com.example.jaime.androidthings_rainbowhat.managers.RainbowConfigurationConstants.I2CBUS;

public class WeatherSensorManager {

    private SensorManager mSensorManager;
    private Context context;
    private Bmx280SensorDriver weatherSensorDriver;

    public WeatherSensorManager(Context context){
        this.context = context;
    }

    public void load(){
        mSensorManager = ((SensorManager) context.getSystemService(SENSOR_SERVICE));
        try {
            weatherSensorDriver = new Bmx280SensorDriver(I2CBUS);
            mSensorManager.registerDynamicSensorCallback(sensorCallback);
            weatherSensorDriver.registerTemperatureSensor();
            weatherSensorDriver.registerPressureSensor();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private SensorEventListener mTemperatureListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
//            mLastTemperature = event.values[0];

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
//            Log.d(TAG, "accuracy changed: " + accuracy);
        }
    };

    private SensorManager.DynamicSensorCallback sensorCallback = new SensorManager.DynamicSensorCallback() {
        @Override
        public void onDynamicSensorConnected(Sensor sensor) {
            if (sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE) {
//                mSensorManager.registerListener(mTemperatureListener, sensor,
//                        SensorManager.SENSOR_DELAY_NORMAL);
            }
        }
        @Override
        public void onDynamicSensorDisconnected(Sensor sensor) {
            super.onDynamicSensorDisconnected(sensor);
        }
    };
}
