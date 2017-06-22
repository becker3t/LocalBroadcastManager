package com.example.android.localbroadcastmanager;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String NAME_EXTRA = "TheBestName";

    private static final String THE_BEST_NAME = "Tom";

    private static final String CUSTOM_EVENT_NAME = "DoTheGreatestThingEver";

    private MyReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnBroadcast).setOnClickListener(this);

        receiver = new MyReceiver();
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, new IntentFilter(CUSTOM_EVENT_NAME));
    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
    }

    private void prepareBroadcast() {
        Intent i = new Intent(CUSTOM_EVENT_NAME);
        Bundle b = new Bundle();
        b.putString(NAME_EXTRA, THE_BEST_NAME);
        i.putExtras(b);
        LocalBroadcastManager.getInstance(this).sendBroadcast(i);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBroadcast:
                prepareBroadcast();
                break;
        }
    }
}
