package com.pankaj.eventbusdemo.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

    String msg = "";
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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        etVal.setText(msg);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnSend:
                SendEvent.FragmentTwoToOne fragmentTwoToOne = new SendEvent.FragmentTwoToOne(etVal.getText().toString());
                // Post the event

                EventBus.getDefault().post(fragmentTwoToOne);

                break;
        }
    }

    @Subscribe
    public void onFragmentOnClick(SendEvent sendEvent) {

        msg = sendEvent.getMessage();
        etVal.setText(msg);

    }

    public void setData(SendEvent event) {
        msg = event.getMessage();

    }
}
