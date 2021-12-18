package com.example.walkitoff;

import android.widget.TimePicker;

public class TimePickerListener implements TimePicker.OnTimeChangedListener{

    @Override
    public void onTimeChanged(TimePicker timePicker, int hour, int minute) {

        MainActivity.hour = hour;
        MainActivity.minute = minute;
    }
}
