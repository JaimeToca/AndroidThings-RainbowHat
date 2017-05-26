package com.example.jaime.androidthings_rainbowhat.managers;

import android.support.annotation.Nullable;
import com.google.android.things.contrib.driver.rainbowhat.RainbowHat;
import com.google.android.things.pio.Gpio;
import java.io.IOException;

public class LedsABCManager {

    public static String A_RED = "BCM6";
    public static String B_GREEN = "BCM19";
    public static String C_BLUE = "BCM26";
    private Gpio led;

    public void powerOnLed(String ledColor){
        led = getLed(ledColor);

        if (led == null) return;

        try {
            led.setValue(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void powerOffLed(String ledColor){
        led = getLed(ledColor);

        if (led == null) return;

        try {
            led.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    private Gpio getLed(String led){
        try {
            return RainbowHat.openLed(led);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
