package com.example.walkitoff;

import android.content.Context;

public class AlarmPreset {

    private String alarmLabel, sound;
    private int time;

    private Context context;

    /**
     * constructor for alarm preset
     * <p>
     * note: add distance to parameter as soon as the feature for choosing goal distance is
     * implemented
     *
     * @param sound - the name of the sound to wake up to
     */
    public AlarmPreset( Context context, int hour, int minute, String sound ){

        this.time = Time.parseTime( hour, minute );
        this.sound = sound;

        this.context = context;

        alarmLabel =
                Time.formatAlarmLabel( hour, minute ) + " - (" + MainActivity.chosenSound + ")";

    }

    /**
     *
     * @return string for alarm preset spinner
     */
    public String getAlarmLabel(){

        return alarmLabel;
    }

    public Alarm makeAlarm(){

        return new Alarm( context, time, sound );
    }
}
