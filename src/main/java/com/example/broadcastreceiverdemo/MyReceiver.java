package com.example.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d("API123",""+intent.getAction());

        if(intent.getAction().equals("com.example.broadcastreceiverdemo.SOME_ACTION"))
            Toast.makeText(context, "SOME_ACTION is received", Toast.LENGTH_LONG).show();

        else {
            ConnectivityManager cm =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null &&
                    activeNetwork.isConnectedOrConnecting();
            if (isConnected) {
                try {
                    Toast.makeText(context, "Network is connected", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(context, "Network is changed or reconnected", Toast.LENGTH_LONG).show();
            }
        }
    }

}
