/*
 * Copyright (C) 2017 Jaime Toca.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.jaime.androidthings_rainbowhat.managers;

import android.content.Context;
import com.google.android.things.contrib.driver.bmx280.Bmx280;
import com.google.android.things.contrib.driver.rainbowhat.RainbowHat;
import android.os.Handler;
import java.io.IOException;

public class WeatherSensorManager {

    private static final String TAG = "WeatherSensorManager";
    private static final long READ_EVERY = 20000;

    private Handler handler;
    private Bmx280 sensor;
    private Context context;
    private float temperature, pressure;
    private AlphaNumericDisplayManager displayManager;

    public WeatherSensorManager(Handler handler, Context context,
                                AlphaNumericDisplayManager displayManager){
        this.context = context;
        this.displayManager = displayManager;
    }

    public void load(){
        try {
            sensor = RainbowHat.openSensor();
            sensor.setMode(Bmx280.MODE_NORMAL);
            sensor.setTemperatureOversampling(Bmx280.OVERSAMPLING_1X);
            sensor.setPressureOversampling(Bmx280.OVERSAMPLING_1X);
            handler = new Handler();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showTemperatureAndPressure(){
        handler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    temperature = fahrenheitToCelsius(sensor.readTemperature());
                    pressure = sensor.readPressure();
                    displayManager.display(temperature);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                handler.postDelayed(this, READ_EVERY);
            }
        });
    }

    public void close(){
        try {
            sensor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private float fahrenheitToCelsius(float temperature){
        return  ((temperature - 32)*5)/9;
    }
}
