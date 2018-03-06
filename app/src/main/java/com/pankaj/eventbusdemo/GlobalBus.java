package com.pankaj.eventbusdemo;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by user on 06-Mar-18.
 */

public class GlobalBus {
    private static EventBus sBus;

    public static EventBus getBus() {
        if (sBus == null)
            sBus = EventBus.getDefault();
        return sBus;
    }
}
