package com.example.walkitoff;
/* TODO
- uncomment score Methods
- uncomment score variables
- Load Values from DB
- Constructor
- Get methods
- changed multyplyer
* */
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    public static String uID,uName,uDistance,uScore,uLevel, chosenSound, chosenPresetLabel;

    static final int REQUEST_PERMISSION = 1;
    public static int hour, minute, level = 0;

    public static AlarmList alarmList = new AlarmList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions( this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_PERMISSION );

        Theme.initializeThemeSwitch( this );
        Theme.initializeSwitchListener( this );

        SoundSpinner.fillSoundSpinner( this );

        // set time picker listener
        TimePicker timePicker = findViewById(R.id.timepicker);
        timePicker.setOnTimeChangedListener( new TimePickerListener() );

        // set spinner listeners
        Spinner soundSpinner = findViewById( R.id.soundspinner );
        soundSpinner.setOnItemSelectedListener( new SoundSpinner() );

        Spinner presetSpinner = findViewById( R.id.presetspinner );
        presetSpinner.setOnItemSelectedListener( new PresetSpinner() );

        // set button listeners
        Button alarmButton = findViewById( R.id.alarmbutton );
        alarmButton.setOnClickListener( new AlarmButtonPress( this ) );

        Button saveButton = findViewById( R.id.savebutton );
        saveButton.setOnClickListener( new SaveButtonPress( this ) );

        Button loginButton = findViewById( R.id.loginbutton );
        loginButton.setOnClickListener( new LoginButtonPress( this ) );
    }
    }
