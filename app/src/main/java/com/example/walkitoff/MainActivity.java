package com.example.walkitoff;
/* TODO
- uncomment score Methods
- uncomment score variables
- Make connect Activity
- Connect to DB
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
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {

    String chosenSound, chosenPresetLabel;

    public static String uID,uName,uDistance,uScore,uLevel;

    static final int REQUEST_PERMISSION = 1;

    int level = 0;

    AlarmList alarmList = new AlarmList();

    int hour, minute;

    private Theme settings;
    private SwitchMaterial themeSwitch;
    private TextView themeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settings = (Theme) getApplication();
        initWidgets();
        loadSharedPreferences();
        initSwitchListener();

        // request permission for location services
        ActivityCompat.requestPermissions( this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_PERMISSION );

        // initialize time picker
        TimePicker timeSelected = findViewById( R.id.timepicker );

        // create anonymous class for time change listener
        timeSelected.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int inHour, int inMinute) {

                // save the chosen hour and minute
                hour = inHour;
                minute = inMinute;
            }

        });
        // end anonymous class

        fillSoundMenu();

        Spinner soundSpinner = findViewById( R.id.soundspinner );
        Spinner presetSpinner = findViewById( R.id.presetspinner );

        presetSpinner.setOnItemSelectedListener( new PresetSpinnerClass() );
        soundSpinner.setOnItemSelectedListener( new SoundSpinnerClass() );

        Button alarmButton = findViewById( R.id.alarmbutton );
        Button saveButton = findViewById( R.id.savebutton );

        // called by alarm button
        alarmButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if( chosenPresetLabel == null ){

                    MediaPlayer sound = MediaPlayer.create(
                            MainActivity.this, SoundFacade.getSound( chosenSound ) );

                    AlarmPreset preset =
                            new AlarmPreset( MainActivity.this, hour, minute, sound );

                    alarmList.addPreset( preset );

                    chosenPresetLabel = preset.getAlarmLabel();
                }

                Alarm alarm = alarmList.findPreset( chosenPresetLabel ).makeAlarm();

                alarm.setAlarm();

                level++;

                fillSoundMenu();

            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MediaPlayer sound =
                        MediaPlayer.create( MainActivity.this, SoundFacade.getSound( chosenSound ) );

                AlarmPreset preset =
                        new AlarmPreset( MainActivity.this, hour, minute, sound );

                alarmList.addPreset( preset );

                fillPresetMenu();
            }
        });
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

    class SoundSpinnerClass implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            chosenSound = adapterView.getItemAtPosition( i ).toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
            chosenSound = SoundName.DEFAULT_SOUND;
        }
    }

    class PresetSpinnerClass implements AdapterView.OnItemSelectedListener{
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            chosenPresetLabel = adapterView.getItemAtPosition( i ).toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }


    /**
     * fills the drop down spinner menu with unlocked sounds
     */
    private void fillSoundMenu(){

        String[] soundArray = SoundFacade.getSoundArray( level );

        Spinner soundSpinner = findViewById( R.id.soundspinner );

        ArrayAdapter<String> soundAdapter =
                new ArrayAdapter<String>( this,
                        android.R.layout.simple_list_item_1, soundArray );

        soundAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );

        soundSpinner.setAdapter( soundAdapter );
    }

    /**
     * fills second dropdown menu with alarm presets
     */
    private void fillPresetMenu(){

        Spinner presetSpinner = findViewById( R.id.presetspinner );

        String[] alarmLabelArray = new String[ alarmList.size ];

        int index;

        for( index = 0; index < alarmList.size; index++ ){

            alarmLabelArray[ index ] = alarmList.alarmArray[ index ].getAlarmLabel();
        }

        ArrayAdapter<String> presetAdapter =new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, alarmLabelArray );

        presetAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );

        presetSpinner.setAdapter( presetAdapter );
    }

    //This is our login activity being created.
    public void connectDB(View view){

        Intent intent = new Intent(this, ConnectDB.class);
        startActivity(intent);
    }

}
