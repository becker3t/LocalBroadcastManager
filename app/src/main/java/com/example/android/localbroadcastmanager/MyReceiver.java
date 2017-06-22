package com.example.android.localbroadcastmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Android on 6/21/2017.
 */

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String name = intent.getExtras().getString(MainActivity.NAME_EXTRA);
        Toast.makeText(context, "Broadcast intent received from the\ngreatest person in the world, " + name, Toast.LENGTH_SHORT).show();
    }
}
