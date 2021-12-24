package com.example.walkitoff;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class Theme extends Application {

    public static final String CUSTOM_THEME = "customTheme";
    public static final String DARK_THEME = "darkTheme";
    public static final String LIGHT_THEME = "lightTheme";
    public static final String PREFERENCES = "preferences";

    public static String customTheme;
    public static Theme settings;
    public static SwitchMaterial themeSwitch;
    public static TextView themeTextView;

    public static void initializeThemeSwitch( Activity activity ){

        settings = (Theme)activity.getApplication();
        themeSwitch = activity.findViewById( R.id.themeSwitch );
        themeTextView = activity.findViewById( R.id.themeTV );

        loadSharedPreferences( activity );
    }

    public static void initializeSwitchListener( Activity activity ) {
        Theme.themeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean checked) {
                if (checked)
                    Theme.customTheme = Theme.DARK_THEME;
                else
                    Theme.customTheme = Theme.LIGHT_THEME;

                SharedPreferences.Editor editor =
                        activity.getSharedPreferences(Theme.PREFERENCES, MODE_PRIVATE).edit();
                editor.putString(Theme.CUSTOM_THEME, Theme.settings.customTheme);
                editor.apply();
                updateView();
            }
        });
    }

        private static void loadSharedPreferences( Activity activity ){

            SharedPreferences sharedPreferences =
                    activity.getSharedPreferences(Theme.PREFERENCES, MODE_PRIVATE);
            String theme = sharedPreferences.getString(Theme.CUSTOM_THEME, Theme.LIGHT_THEME);
            Theme.customTheme = theme;
            updateView();
        }

        private static void updateView (){

            if (Theme.settings.customTheme.equals(Theme.DARK_THEME)) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                Theme.themeTextView.setText("Dark Theme");
                Theme.themeSwitch.setChecked(true);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                Theme.themeSwitch.setChecked(false);
            }
        }
}
