package com.kenny.smarttips;

import android.app.Activity;
import android.support.annotation.NonNull;

/**
 * Created by Kenny on 2017/7/31 14:56.
 * Desc:
 */

public final class SmartTips {

    private Activity activity;
    private Configuration config;

    private SmartTips(Activity activity, Configuration config) {
        this.activity = activity;
        this.config = config;
    }

    public static SmartTips makeNotice(@NonNull Activity activity, @NonNull Configuration config) {
        return new SmartTips(activity, config);
    }

    public static void hideLast() {
        NotificationManager.Instance().remove();
    }

    public static void cancelAll() {
        NotificationManager.Instance().cancelAll();
    }

    public void show() {
        NotificationManager.Instance().add(this);
    }

    public Activity getActivity() {
        return activity;
    }


    public Configuration getConfig() {
        return config;
    }
}
