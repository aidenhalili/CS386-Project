package com.example.walkitoff;

import android.content.Context;
import android.view.View;

public class SaveButtonPress extends ButtonPress{

    private Context context;

    public SaveButtonPress( Context context ){

        this.context = context;
    }

    @Override
    public void onClick(View view) {

        AlarmPreset preset = new AlarmPreset(
                context, MainActivity.hour, MainActivity.minute, MainActivity.chosenSound );

        MainActivity.alarmList.addPreset( preset );

        PresetSpinner.fillPresetSpinner( context );
    }


}
