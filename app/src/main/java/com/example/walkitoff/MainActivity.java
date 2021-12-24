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
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
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

        initializeThemeSwitch();
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


    private void loadSharedPreferences() {

        SharedPreferences sharedPreferences = getSharedPreferences(Theme.PREFERENCES, MODE_PRIVATE);
        String theme = sharedPreferences.getString(Theme.CUSTOM_THEME, Theme.LIGHT_THEME);
        Theme.customTheme = theme;
        updateView();
    }

    private void initSwitchListener() {
        Theme.themeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean checked) {
                if(checked)
                    Theme.customTheme = Theme.DARK_THEME;
                else
                    Theme.customTheme = Theme.LIGHT_THEME;

                SharedPreferences.Editor editor = getSharedPreferences(Theme.PREFERENCES, MODE_PRIVATE).edit();
                editor.putString(Theme.CUSTOM_THEME, Theme.settings.getCustomTheme());
                editor.apply();
                updateView();


            }
        });
    }

    private void updateView() {

        if(Theme.settings.getCustomTheme().equals(Theme.DARK_THEME))
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            Theme.themeTextView.setText("Dark Theme");
            Theme.themeSwitch.setChecked(true);
        }
        else
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            Theme.themeSwitch.setChecked(false);
        }

    }

    private void initializeThemeSwitch(){

        Theme.settings = (Theme) getApplication();
        Theme.themeSwitch = findViewById(R.id.themeSwitch);
        Theme.themeTextView = findViewById(R.id.themeTV);

        loadSharedPreferences();
        initSwitchListener();
    }
}
