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

import android.content.Context;

import com.example.jaime.androidthings_rainbowhat.managers.AlphaNumericDisplayManager;
import com.example.jaime.androidthings_rainbowhat.managers.LedsABCManager;
import com.example.jaime.androidthings_rainbowhat.managers.RainbowLedsManager;
import com.example.jaime.androidthings_rainbowhat.managers.WeatherSensorManager;

public class DependencyInjector {

    private static DependencyInjector ourInstance;

    public static DependencyInjector getInstance() {
        if ( ourInstance == null) return new DependencyInjector();

        return ourInstance;
    }

    public AlphaNumericDisplayManager injectAlphaNumericDisplayManager(){
        return new AlphaNumericDisplayManager();
    }

    public LedsABCManager injectLedsABCManager(){
        return new LedsABCManager();
    }

    public RainbowLedsManager injectRainbowLedsManager(){
        return new RainbowLedsManager();
    }

    public WeatherSensorManager injectWeatherSensorManager(Context context){
        return new WeatherSensorManager(context);
    }
}
