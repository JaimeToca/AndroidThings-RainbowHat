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

package com.example.jaime.androidthings_rainbowhat;

import android.app.Activity;
import android.os.Bundle;
import com.example.jaime.androidthings_rainbowhat.managers.AlphaNumericDisplayManager;
import com.example.jaime.androidthings_rainbowhat.managers.RainbowLedsManager;
import com.example.jaime.androidthings_rainbowhat.managers.WeatherSensorManager;

public class WeatherStationActivity extends Activity {

    private WeatherSensorManager weatherSensorManager;
    private AlphaNumericDisplayManager alphaNumericDisplayManager;
    private RainbowLedsManager rainbowLedsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weatherSensorManager = DependencyInjector.getInstance().injectWeatherSensorManager(this);
        alphaNumericDisplayManager = DependencyInjector.getInstance().injectAlphaNumericDisplayManager();
        rainbowLedsManager = DependencyInjector.getInstance().injectRainbowLedsManager();
        loadDrivers();
    }

    private void loadDrivers(){
        alphaNumericDisplayManager.load();
        weatherSensorManager.load();
        rainbowLedsManager.load();
    }

    @Override
    protected void onStart() {
        super.onStart();
        weatherSensorManager.showTemperatureAndPressure(alphaNumericDisplayManager, rainbowLedsManager);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        alphaNumericDisplayManager.clear();
        weatherSensorManager.close();
    }
}
