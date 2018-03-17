package com.pankaj.eventbusdemo.rx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.pankaj.eventbusdemo.R;
import com.pankaj.eventbusdemo.networking.ApiClient;
import com.pankaj.eventbusdemo.networking.ApiInterface;
import com.pankaj.eventbusdemo.rx.response.IpResponse;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RxJavaWithRetrofitActivity extends AppCompatActivity {

    private static final String TAG = "RxJavaWithRetrofitActiv";
    ApiInterface apiInterface;
    Observer<IpResponse> mIpResponseObserver = new Observer<IpResponse>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(IpResponse ipResponse) {

            Log.d(TAG, "City_name : " + ipResponse.getData().getCity_name());
            Log.d(TAG, "Latitude: " + ipResponse.getData().getLatitude());
            Log.d(TAG, "Longitude: " + ipResponse.getData().getLongitude());
        }

        @Override
        public void onError(Throwable e) {

            Log.d(TAG, "onError: ");
        }

        @Override
        public void onComplete() {
            Log.d(TAG, "onComplete: ");

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_with_retrofit);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        apiInterface.getIpInfo().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .retry(3)
                .subscribe(mIpResponseObserver);


    }

    //Disposable disposable = new
}
