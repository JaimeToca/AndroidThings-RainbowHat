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

import com.google.android.things.contrib.driver.ht16k33.AlphanumericDisplay;
import com.google.android.things.contrib.driver.rainbowhat.RainbowHat;
import java.io.IOException;

public class AlphaNumericDisplayManager {

    private AlphanumericDisplay alphanumericDisplay;

    public void load(){
        try {
            alphanumericDisplay = RainbowHat.openDisplay();
            alphanumericDisplay.setEnabled(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void display(String text){
        try {
            alphanumericDisplay.display(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void display(Float number){
        try {
            alphanumericDisplay.display(number);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clear(){
        try {
            alphanumericDisplay.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
