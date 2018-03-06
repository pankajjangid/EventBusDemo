package com.pankaj.eventbusdemo.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.pankaj.eventbusdemo.R;
import com.pankaj.eventbusdemo.SendEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTwo extends Fragment implements View.OnClickListener {

    View mainView;
    Context mContext;
    Button btnSend;
    EditText etVal;

    public FragmentTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView = inflater.inflate(R.layout.fragment_two, container, false);
        findControls();
        return mainView;
    }

    private void findControls() {
        mContext = getActivity();
        EventBus.getDefault().register(this);
        btnSend = mainView.findViewById(R.id.btnSend);
        etVal = mainView.findViewById(R.id.etVal);

        btnSend.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnSend:
                SendEvent sendEvent = new SendEvent(etVal.getText().toString());
                // Post the event

                EventBus.getDefault().post(sendEvent);

                break;
        }
    }

    @Subscribe
    public void onFragmentOnClick(SendEvent sendEvent) {

        etVal.setText(sendEvent.getMessage());
    }

}
