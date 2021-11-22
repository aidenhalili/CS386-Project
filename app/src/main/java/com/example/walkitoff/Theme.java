package com.example.walkitoff;

import android.app.Application;

public class Theme extends Application {

    public static final String CUSTOM_THEME = "customTheme";
    public static final String DARK_THEME = "darkTheme";
    public static final String LIGHT_THEME = "lightTheme";
    public static final String PREFERENCES = "preferences";

    private String customTheme;

    public String getCustomTheme() {
        return customTheme;
    }

    public void setCustomTheme(String customTheme) {
        this.customTheme = customTheme;
    }
}
