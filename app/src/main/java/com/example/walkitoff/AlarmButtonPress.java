package com.example.walkitoff;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class AlarmButtonPress extends ButtonPress{

    private final Context context;

    public AlarmButtonPress( Context context ){

        this.context = context;
    }

    @Override
    public void onClick( View view ){

        if( MainActivity.chosenPresetLabel == null ){

            AlarmPreset preset = new AlarmPreset(
                    context, MainActivity.hour, MainActivity.minute, MainActivity.chosenSound );

            MainActivity.alarmList.addPreset( preset );

            MainActivity.chosenPresetLabel = preset.getAlarmLabel();
        }

        context.startService( new Intent( context, BackgroundService.class ) );

        MainActivity.level++;

        SoundSpinner.fillSoundSpinner( context );
    }
}
