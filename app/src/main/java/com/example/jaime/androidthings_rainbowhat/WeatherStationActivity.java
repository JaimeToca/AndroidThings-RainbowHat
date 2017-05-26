package com.example.jaime.androidthings_rainbowhat;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.example.jaime.androidthings_rainbowhat.managers.LedsABCManager;
import com.google.android.things.contrib.driver.rainbowhat.RainbowHat;
import com.google.android.things.pio.Gpio;
import java.io.IOException;
import android.os.Handler;
import static com.example.jaime.androidthings_rainbowhat.managers.LedsABCManager.*;

public class WeatherStationActivity extends Activity {

    private static String TAG = "RainbowHat";
    private LedsABCManager ledsABCManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Started Weather Station");

        ledsABCManager = new LedsABCManager();

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
