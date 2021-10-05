package com.example.walkitoff;

import android.location.Location;
import android.location.LocationManager;

public class Distance {

    /*
    this class keeps track of distance the user travelled.
    the plan is to create an object
     */

    private int travelledDistance, goalDistance;

    private double longitude, latitude;

    private Location location;
    private LocationManager locationManager;

    /*
    default distance goal in feet
     */
    private static final int DEFAULT_GOAL = 500;

    /**
     * default constructor
     *
     * @param inLocationManager
     */
    public Distance( LocationManager inLocationManager ){

        travelledDistance = 0;
        longitude = 0;
        latitude = 0;

        goalDistance = DEFAULT_GOAL;

        locationManager = inLocationManager;
        location = null;

    }

    /**
     * initialization constructor
     *
     * @param inLocationManager
     *
     * @param inGoalDistance - user set goal distance
     */
    public Distance( LocationManager inLocationManager, int inGoalDistance ){

        travelledDistance = 0;
        longitude = 0;
        latitude = 0;

        goalDistance = inGoalDistance;

        locationManager = inLocationManager;
        location = null;
    }

    /**
     * used to access travelled distance outside of class
     *
     * @return travelledDistance
     */
    public int getTravelledDistance(){

        return travelledDistance;
    }
    /**
     * converts distance in meters to feet
     *
     * @return - distance in feet
     */
    private int toFeet(){

        // temporary return stub
        return 0;
    }

    /**
     * called by setAlarm method in Alarm class.
     * <p>
     * updates distance every one second until goal distance is reached
     */
    public void trackDistance(){

    }

    /**
     * gets current distance between current location and last known location
     */
    private void updateDistance(){

    }

}
