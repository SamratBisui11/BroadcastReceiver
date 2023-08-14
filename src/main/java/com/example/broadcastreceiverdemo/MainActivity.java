package com.example.broadcastreceiverdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    MyReceiver receiver;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiver = new MyReceiver();
        intentFilter = new IntentFilter("com.example.broadcastreceiverdemo.SOME_ACTION");
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    @OnClick(R.id.Button)
    void somemethod(){
        Intent intent = new Intent("com.example.broadcastreceiverdemo.SOME_ACTION");
        sendBroadcast(intent);
    }
    }
