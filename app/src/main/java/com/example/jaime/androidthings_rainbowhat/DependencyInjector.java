package com.example.jaime.androidthings_rainbowhat;

public class DependencyInjector {

    private static final DependencyInjector ourInstance = new DependencyInjector();

    public static DependencyInjector getInstance() {
        return ourInstance;
    }

    private DependencyInjector() {
    }


}
