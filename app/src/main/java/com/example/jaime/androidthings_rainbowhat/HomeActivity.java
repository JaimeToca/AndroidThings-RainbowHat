package com.example.jaime.androidthings_rainbowhat;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.google.android.things.contrib.driver.rainbowhat.RainbowHat;
import com.google.android.things.pio.Gpio;

import java.io.IOException;
import android.os.Handler;

public class HomeActivity extends Activity {

    private Handler handler = new Handler();
    private static String TAG = "RainbowHat";
    private Gpio led;

    private static String LED_A_RED = "BCM6";
    private static String LED_B_GREEN = "BCM19";
    private static String LED_C_BLUE = "BCM26";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Started Weather Station");

        try {
            led = RainbowHat.openLed(LED_C_BLUE);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            led.setValue(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        try {
            led.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
