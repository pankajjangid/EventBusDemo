package com.pankaj.eventbusdemo;

/**
 * Created by user on 06-Mar-18.
 */

public class SendEvent {

    public String message;

    public SendEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static class FragmentTwoToOne {

        public String msg;

        public FragmentTwoToOne(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }
    }
}
