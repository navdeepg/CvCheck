package com.cvcheck;

import android.app.Application;
import android.content.Context;

public class ApplicationData extends Application {

    private static ApplicationData mInstance;

    @Override
    public void onCreate() {
        // Remember the one-and-only application instance.
        mInstance = this;
        super.onCreate();

    }
    public static Context getContext() {
        return mInstance.getApplicationContext();
    }

}
