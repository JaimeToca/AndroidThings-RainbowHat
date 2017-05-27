package com.example.jaime.androidthings_rainbowhat.managers;

import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.things.contrib.driver.rainbowhat.RainbowHat;
import com.google.android.things.pio.Gpio;
import java.io.IOException;

public class LedsABCManager {

    public static String LED_RED = "BCM6";
    public static String LED_GREEN = "BCM19";
    public static String LED_BLUE = "BCM26";

    private Gpio led;

    public void powerOnLed(String ledColor){
        led = getLed(ledColor);

        if (led == null){
            Log.e("LEDSABCManager", "Opsss could not power on led "+ ledColor);
            return;
        }

        try {
            led.setValue(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void powerOffLed(String ledColor){
        led = getLed(ledColor);

        if (led == null){
            Log.e("LEDSABCManager", "Opsss could not power off led "+ ledColor);
            return;
        }

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
