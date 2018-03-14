package com.pankaj.eventbusdemo.networking;

import android.content.Context;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by user on 06-Mar-18.
 */

public class RetrofitCallback<T> implements Callback<T> {
    @SuppressWarnings("unused")
    private static final String TAG = "RetrofitCallback";
    private final Callback<T> mCallback;
    private Context mContext;

    public RetrofitCallback(Context context, Callback<T> callback) {
        mContext = context;
        this.mCallback = callback;
    }

    @Override
    public void onResponse(Call<T> call, retrofit2.Response<T> response) {
// Do application relavent custom operation like manupulating reponse etc.
        //  AlertDialogHelper.dismiss(mContext);
        mCallback.onResponse(call, response);
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
// Handle error etc.
        //    NetworkHelper.onFailure(t, (Activity) mContext);
        mCallback.onFailure(call, t);
    }
}
