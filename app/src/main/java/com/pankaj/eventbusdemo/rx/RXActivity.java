package com.pankaj.eventbusdemo.rx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.pankaj.eventbusdemo.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RXActivity extends AppCompatActivity {

    private static final String TAG = "RXActivity";

    Observable<Integer> mObservable = Observable.just(1, 2, 3, 4, 6)
            .delay(1, TimeUnit.SECONDS);
    Observer<Integer> mObserver = new Observer<Integer>() {
        @Override
        public void onSubscribe(Disposable d) {
            Log.e(TAG, "onSubscribe: ");
        }

        @Override
        public void onNext(Integer value) {
            Log.e(TAG, "onNext: " + value);
        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, "onError: ");
        }

        @Override
        public void onComplete() {
            Log.e(TAG, "onComplete: All Done!");
        }
    };

/*    Observable<Integer> mObservable = Observable.create(new ObservableOnSubscribe<Integer>() {
        @Override
        public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {

            SystemClock.sleep(1000);
            emitter.onNext(1);
            emitter.onComplete();
        }
    });*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);


        //Create our subscription//
        mObservable.subscribeOn(Schedulers.newThread())  //Observable runs on new background thread.
                .observeOn(AndroidSchedulers.mainThread()) //Observer will run on main UI thread.
                .subscribe(mObserver); //Subscribe the observer
    }


}
