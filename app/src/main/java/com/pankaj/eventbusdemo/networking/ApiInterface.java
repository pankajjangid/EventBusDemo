package com.pankaj.eventbusdemo.networking;


import com.pankaj.eventbusdemo.rx.response.IpResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Pankaj Jangid on 05-Apr-17 .
 */

public interface ApiInterface {

    @GET("8.8.8.8")
    Observable<IpResponse> getIpInfo();
}
