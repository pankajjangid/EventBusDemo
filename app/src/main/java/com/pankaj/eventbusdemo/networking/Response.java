package com.pankaj.eventbusdemo.networking;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pankaj on 16/6/17.
 */

public class Response {
    @SerializedName("status")
    public String status;

    @SuppressWarnings({"unused", "used by Retrofit"})
    public Response() {
    }

    public Response(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
