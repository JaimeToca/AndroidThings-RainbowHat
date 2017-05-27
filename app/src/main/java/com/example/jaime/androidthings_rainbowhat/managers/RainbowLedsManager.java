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

import android.graphics.Color;
import android.util.Log;
import com.google.android.things.contrib.driver.apa102.Apa102;
import java.io.IOException;
import static com.example.jaime.androidthings_rainbowhat.managers.RainbowConfigurationConstants.SPIBUS;

public class RainbowLedsManager {

    private static final int N_LEDS = 7;
    private static final int LEDSTRIP_BRIGHTNESS = 1;
    private static final float BAROMETER_RANGE_LOW = 965.f;
    private static final float BAROMETER_RANGE_RAINY = 990.f;
    private static final float BAROMETER_RANGE_HIGH = 1035.f;
    private static final float BAROMETER_RANGE_SUNNY = 1010.f;

    private int[] rainbowColors = new int[N_LEDS];
    private Apa102 rainbowLeds;

    public void load(){
        try {
            rainbowLeds = new Apa102(SPIBUS, Apa102.Mode.BGR);
            rainbowLeds.setBrightness(LEDSTRIP_BRIGHTNESS);
            configureRainbowLedsColor();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void configureRainbowLedsColor() {
        for (int i = 0; i < rainbowColors.length; i++) {
            rainbowColors[i] = mapHSVColorToRGB(i);
        }
    }

    /* For more info about HSV check https://en.wikipedia.org/wiki/HSL_and_HSV
     * In this example the saturation and value will remain constant, only
     * surface values of the hsv matrix can be chosen depending on led position */
    private int mapHSVColorToRGB(int ledPosition){
        float[] hsv = {ledPosition * 360.f / N_LEDS, 1.0f, 1.0f};
        return Color.HSVToColor(255,hsv);
    }

    /* https://github.com/androidthings/weatherstation/blob/master/app/src/main/java/
     * com/example/androidthings/weatherstation/WeatherStationActivity.java */
    public void powerOnRainbowLeds(float pressure){
        float t = (pressure - BAROMETER_RANGE_LOW) / (BAROMETER_RANGE_HIGH - BAROMETER_RANGE_LOW);
        int n = (int) Math.ceil(N_LEDS * t);
        n = Math.max(0, Math.min(n, N_LEDS));
        int[] colors = new int[N_LEDS];
        for (int i = 0; i < n; i++) {
            int ri = rainbowColors.length - 1 - i;
            colors[ri] = rainbowColors[ri];
        }
        try {
            rainbowLeds.write(colors);
        } catch (IOException e) {
            Log.e("RainbowLedsManager", "Error setting ledstrip", e);
        }
    }

}
