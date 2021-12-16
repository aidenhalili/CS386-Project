package com.example.walkitoff;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;

public class PresetSpinner extends MainSpinner{

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        super.onItemSelected(adapterView, view, i, l);

        MainActivity.chosenPresetLabel = selection;
    }

    /**
     * fills second dropdown menu with alarm presets
     */
    public static void fillPresetSpinner( Context context ){

        String[] alarmLabelArray = new String[ MainActivity.alarmList.size ];

        int index;

        for( index = 0; index < MainActivity.alarmList.size; index++ ){

            alarmLabelArray[ index ] = MainActivity.alarmList.alarmArray[ index ].getAlarmLabel();
        }

        MainSpinner.fillSpinner( context, alarmLabelArray, R.id.presetspinner );
    }
}
