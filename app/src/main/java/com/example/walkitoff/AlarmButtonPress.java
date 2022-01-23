package com.example.walkitoff;

import android.content.Context;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AlarmButtonPress extends ButtonPress{

    private Context context;

    public AlarmButtonPress( Context context ){

        this.context = context;
    }

    @Override
    public void onClick( View view ){

        if( MainActivity.chosenPresetLabel == null ){

            Date time = new Date();

            MainActivity.hour = Integer.parseInt(new SimpleDateFormat("HH").format(time));

            MainActivity.minute = Integer.parseInt(new SimpleDateFormat("mm").format(time));

            AlarmPreset preset = new AlarmPreset(
                    context, MainActivity.hour, MainActivity.minute, MainActivity.chosenSound );

            MainActivity.alarmList.addPreset( preset );

            MainActivity.chosenPresetLabel = preset.getAlarmLabel();
        }

        Alarm alarm =
                MainActivity.alarmList.findPreset( MainActivity.chosenPresetLabel ).makeAlarm();

        alarm.setAlarm();

        MainActivity.level++;

        SoundSpinner.fillSoundSpinner( context );
    }
}
