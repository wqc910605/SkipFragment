package com.zhongyuan.fragmentanimation;

import android.app.Application;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zy01060 on 2018/1/4.
 */

public class MyApp extends Application {
    public static Map<String, Boolean> sIsBackProcesses;
    @Override
    public void onCreate() {
        super.onCreate();
        sIsBackProcesses = new HashMap<>();
    }
}
