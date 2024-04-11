package com.example.progect7_2.Data.DataSourse.SharedPreferences;

import android.content.SharedPreferences;
import static android.provider.Settings.System.getString;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.progect7_2.R;

public class SharedPreferencesDS {
    private final String fileName = "PREFERENCE_FILE_KEY";
    private final Context context;
    private final SharedPreferences spf;
    public SharedPreferencesDS(Context context) {
        this.context = context;
        spf = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }
    public void writeString(String key, String content) {
        SharedPreferences.Editor editor = spf.edit();
        if (!spf.getString(key, "").equals("")) editor.remove(key);
        editor.putString(key, content);
        editor.apply();
    }
    public void writeInt(String key, int content) {
        SharedPreferences.Editor editor = spf.edit();
        if (spf.getInt(key, -1) != -1) editor.remove(key);
        editor.putInt(key, content);
        editor.apply();
    }
    public void writeBool(String key, boolean content) {
        SharedPreferences.Editor editor = spf.edit();
        if (spf.getBoolean(key, false)) editor.remove(key);
        editor.putBoolean(key, content);
        editor.apply();
    }
    public int getInt(String key) {
        int defaultValue = -1;
        return spf.getInt(key, defaultValue);
    }
    public String getString(String key) {
        String defaultValue = "";
        return spf.getString(key, defaultValue);
    }
    public boolean getBool(String key) {
        boolean defaultValue = false;
        return spf.getBoolean(key, defaultValue);
    }
}