package com.example.walkitoff;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class BackgroundService extends Service {

    private static Alarm alarm;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        alarm = MainActivity.alarmList.findPreset(MainActivity.chosenPresetLabel).makeAlarm();
        alarm.setAlarm();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        alarm.stopAlarm();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
