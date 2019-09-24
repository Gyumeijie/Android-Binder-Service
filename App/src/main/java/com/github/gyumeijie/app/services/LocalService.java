package com.github.gyumeijie.app.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

/**
 *   Declares a service (a Service subclass) as one of the application's components. Unlike activities,
 *   services lack a visual user interface. They're used to implement long-running background operations
 *   or a rich communications API that can be called by other applications.
 *
 *   All services must be represented by <service> elements in the manifest file. Any that are not declared
 *   there will not be seen by the system and will never be run.
 */
public class LocalService extends Service {
    public static final int UPPER_BOUND = 100;
    // Binder given to clients
    private final IBinder mBinder = new LocalBinder();
    // Random number generator
    private final Random mGenerator = new Random();

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    // Method for clients
    public int getRandomNumber() {
        return mGenerator.nextInt(UPPER_BOUND);
    }

    // Method for clients
    public int getNumber(int num) {
        return num;
    }

    public class LocalBinder extends Binder {
        public LocalService getService() {
            // Return `this` instance of LocalService so clients can call public methods
            return LocalService.this;
        }
    }
}