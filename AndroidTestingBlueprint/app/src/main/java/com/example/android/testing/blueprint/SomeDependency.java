package com.example.android.testing.blueprint;

import android.util.Log;

import javax.inject.Singleton;

@Singleton
public class SomeDependency {
    public void test() {
        Log.d("TEST", "TEST");
    }
}
