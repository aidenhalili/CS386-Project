package com.example.walkitoff;
/* TODO
- uncomment score Methods
- uncomment score variables
- Load Values from DB
- Constructor
- Get methods
- changed multyplyer
-
* */
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {

    public static String uID,uName,uDistance,uScore,uLevel, chosenSound, chosenPresetLabel;

    static final int REQUEST_PERMISSION = 1;

    public static int hour, minute, level = 0;

    public static AlarmList alarmList = new AlarmList();

    private Theme settings;
    private SwitchMaterial themeSwitch;
    private TextView themeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions( this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_PERMISSION );

        initializeThemeSwitch();

        initializeTimePicker();

        SoundSpinner.fillSoundSpinner( this );

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

    private void initWidgets() {
        themeSwitch = findViewById(R.id.themeSwitch);
        themeTV = findViewById(R.id.themeTV);

    }


    private void loadSharedPreferences() {

        SharedPreferences sharedPreferences = getSharedPreferences(Theme.PREFERENCES, MODE_PRIVATE);
        String theme = sharedPreferences.getString(Theme.CUSTOM_THEME, Theme.LIGHT_THEME);
        settings.setCustomTheme(theme);
        updateView();
    }

    private void initSwitchListener() {
        themeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean checked) {
                if(checked)
                    settings.setCustomTheme(Theme.DARK_THEME);
                else
                    settings.setCustomTheme(Theme.LIGHT_THEME);

                SharedPreferences.Editor editor = getSharedPreferences(Theme.PREFERENCES, MODE_PRIVATE).edit();
                editor.putString(Theme.CUSTOM_THEME, settings.getCustomTheme());
                editor.apply();
                updateView();


            }
        });
    }

    private void updateView() {
        final int black = ContextCompat.getColor(this, R.color.black );
        final int white = ContextCompat.getColor(this, R.color.white );

        if(settings.getCustomTheme().equals(Theme.DARK_THEME))
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            themeTV.setText("Dark Theme");
            themeSwitch.setChecked(true);
        }
        else
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            themeSwitch.setChecked(false);
        }

    }

    private void initializeThemeSwitch(){

        settings = (Theme) getApplication();
        initWidgets();
        loadSharedPreferences();
        initSwitchListener();
    }

    private void initializeTimePicker(){

        TimePicker timePicker = findViewById( R.id.timepicker );

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int inHour, int inMinute) {

                hour = inHour;
                minute = inMinute;
            }
        });
    }

}
