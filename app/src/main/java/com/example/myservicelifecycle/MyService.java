package com.example.myservicelifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import android.os.Process;

// for each start request, we will use a worker thread to perform the job and
// processes only one request at a time.

public class MyService extends Service {

    /** interface for clients that bind */
    // IBinder mBinder;

    /** indicates whether onRebind should be used */
    boolean mAllowRebind;

    public MyService() {
        Log.i("myLog", "MyService()");
    }

    /** Called when the service is being created. */
    @Override
    public void onCreate() {
        Log.i("myLog", "onCreate()");

    }

    /** The service is starting, due to a call to startService() */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("myLog", "onStartCommand() " + startId);

        // Let it continue running until it is stopped.
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();

        // indicates how to behave if the service is killed */
        // If we get killed, after returning from here, restart
        return START_STICKY;
    }

    /** Called when The service is no longer used and is being destroyed */
    @Override
    public void onDestroy() {
        Log.i("myLog", "onDestroy()");
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }

    /** A client is binding to the service with bindService() */
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("myLog", "onBind()");
        return null;
        // return mBinder;
    }


    /** Called when all clients have unbound with unbindService() */
    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("myLog", "onUnbind()");
        return mAllowRebind;
    }

    /** Called when a client is binding to the service with bindService()*/
    @Override
    public void onRebind(Intent intent) {
        Log.i("myLog", "onRebind()");
    }


}
