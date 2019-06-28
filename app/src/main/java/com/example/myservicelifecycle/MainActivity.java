package com.example.myservicelifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // method to start the service
    public void startServiceButtonCB(View view) {
        Log.i("myLog", "starting Service Explicitly");
        startService(new Intent(getBaseContext(), MyService.class));
    }

    // method to stop the service
    public void stopServiceButtonCB(View view) {
        Log.i("myLog", "stopping Service()");
        stopService(new Intent(getBaseContext(), MyService.class));
    }
}
