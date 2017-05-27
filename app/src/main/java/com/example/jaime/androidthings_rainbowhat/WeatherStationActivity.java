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
import android.util.Log;

import com.example.jaime.androidthings_rainbowhat.managers.AlphaNumericDisplayManager;
import com.example.jaime.androidthings_rainbowhat.managers.LedsABCManager;
import com.example.jaime.androidthings_rainbowhat.managers.RainbowLedsManager;
import com.google.android.things.contrib.driver.ht16k33.AlphanumericDisplay;
import com.google.android.things.contrib.driver.rainbowhat.RainbowHat;
import com.google.android.things.pio.Gpio;
import java.io.IOException;
import android.os.Handler;
import static com.example.jaime.androidthings_rainbowhat.managers.LedsABCManager.*;

public class WeatherStationActivity extends Activity {

    private static String TAG = "RainbowHat";
    private LedsABCManager ledsABCManager;
    private AlphanumericDisplay alphanumericDisplay;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Started Weather Station");

        RainbowLedsManager rainbowLedsManager = new RainbowLedsManager();
        rainbowLedsManager.load();
        rainbowLedsManager.powerOnRainbowLeds(981.0f);
    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}
