package com.example.walkitoff;

public class Time {

    /**
     * parses time to string
     *
     * @return - parsed time (ex. 23:12 -> "2312") (String)
     */
    public static int parseTime( int hour, int minute ){

        // variables
        String parsedHour = String.valueOf( hour );
        String parsedMinute = String.valueOf( minute );
        String parsedTime;

        if( minute < 10 ){

            parsedMinute = "0" + parsedMinute;
        }

        parsedTime = parsedHour + parsedMinute;

        return Integer.parseInt( parsedTime );
    }

    /**
     * to be used as an alarm label for alarm preset
     *
     * @return time in 12 hour format
     */
    public static String formatAlarmLabel( int hour, int minute ){

        String parsedHour = String.valueOf( hour );
        String parsedMinute = String.valueOf( minute );
        String meridiem = " AM";

        int midDay = 12;

        if( hour >= midDay ){

            if( hour > midDay ){

                parsedHour = String.valueOf( hour - midDay );
            }

            meridiem = " PM";
        }

        if( minute < 10 ){

            parsedMinute = "0" + String.valueOf( minute );
        }

        return parsedHour + ":" + parsedMinute + meridiem;
    }
}
