package com.example.langchanger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Locale locale = new Locale("en", "US");


        try {
            changeLanguage(locale);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        finish();
    }


    @SuppressWarnings("unchecked")
    public static void changeLanguage(Locale locale)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, NoSuchFieldException {

        // from https://stackoverflow.com/a/49130408

        Class<?> activityManagerNative = Class.forName("android.app.ActivityManager");
        Object am = activityManagerNative.getMethod("getService").invoke(activityManagerNative);
        Configuration config = (Configuration) am.getClass().getMethod("getConfiguration").invoke(am);

        config.setLocale(locale);
        config.getClass().getDeclaredField("userSetLocale").setBoolean(config, true);

        Method methodUpdateConfiguration = am.getClass().getMethod("updatePersistentConfiguration", android.content.res.Configuration.class);
        methodUpdateConfiguration.setAccessible(true);
        methodUpdateConfiguration.invoke(am, config);
    }
}
