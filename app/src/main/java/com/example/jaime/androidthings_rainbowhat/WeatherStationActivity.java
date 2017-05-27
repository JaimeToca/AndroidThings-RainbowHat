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
import com.example.jaime.androidthings_rainbowhat.managers.LedsABCManager;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Started Weather Station");

        try {
            alphanumericDisplay = RainbowHat.openDisplay();
            alphanumericDisplay.setEnabled(true);
            alphanumericDisplay.display("2030");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            RainbowHat.openLedBlue();
        } catch (IOException e) {
            e.printStackTrace();
        }


//        ledsABCManager.powerOnLed(A_RED);
//        ledsABCManager.powerOnLed(B_GREEN);
//        ledsABCManager.powerOnLed(C_BLUE);

//        ledsABCManager.powerOffLed(A_RED);
//        ledsABCManager.powerOffLed(B_GREEN);
//        ledsABCManager.powerOffLed(C_BLUE);


    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}
