package com.example.lab8;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();

        // Start a new thread to run a task
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Simulate a delay (e.g., for loading or doing some work)
                    Thread.sleep(5000);

                    // Create an Intent to start the second activity
                    Intent intent = new Intent(MyService.this, MainActivity2.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    MyService.this.startActivity(intent);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        stopSelf();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        // Return START_STICKY to keep the service running in the background
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Handle cleanup when the service is destroyed
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
