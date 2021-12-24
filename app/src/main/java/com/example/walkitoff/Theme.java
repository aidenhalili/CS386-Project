package com.example.walkitoff;

import android.app.Application;
import android.widget.TextView;

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


    public String getCustomTheme() {
        return customTheme;
    }
}
