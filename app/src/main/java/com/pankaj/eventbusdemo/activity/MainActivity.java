package com.pankaj.eventbusdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.pankaj.eventbusdemo.R;
import com.pankaj.eventbusdemo.SendEvent;
import com.pankaj.eventbusdemo.fragments.FragmentOne;
import com.pankaj.eventbusdemo.fragments.FragmentTwo;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);

        // Register as a subscriber
        getSupportFragmentManager().beginTransaction().replace(R.id.container1, new FragmentOne()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.container2, new FragmentTwo()).commit();


    }

    @Subscribe()
    public void onEvent(SendEvent event) {
        Log.d(TAG, "onEvent: " + event.getMessage());
        // FragmentTwo fragmentTwo =       new FragmentTwo();
        //getSupportFragmentManager().beginTransaction().replace(R.id.container1,fragmentTwo).commit();
        // fragmentTwo.setData(event );
    }

}
