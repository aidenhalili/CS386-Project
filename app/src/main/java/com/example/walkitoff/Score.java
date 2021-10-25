package com.example.walkitoff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Score {

    /*
    For storing, retrieving, and updating the user's total score and level. To be used by sound and
    theme classes to determine which sounds and themes are unlocked.
     */

    // member data
    private static int totalScore, userLevel, scoreReq;
    //userLevel = 1;
    //totalScore = 0;
    //scoreReq = 200;

    /**
     * default constructor
     */
    public Score(){
        totalScore = Integer.parseInt(MainActivity.uScore);
        userLevel = Integer.parseInt(MainActivity.uLevel);
    }

    /**
     * calculates the users level
     */
    private void calcLevel(){

        int multiplyer, scoreCurrent, maxLvl;
        multiplyer = (int)1.3;
        maxLvl = 15;

        scoreCurrent = totalScore;

        if (scoreCurrent >= scoreReq)
            {
                userLevel += 1;
                scoreCurrent = scoreCurrent - scoreReq;
                scoreReq = scoreReq * multiplyer;
                while((scoreReq % 10) != 0)
                    {
                        scoreReq += 1;
                    }
            }

        if (userLevel == maxLvl)
            {
                scoreCurrent = scoreReq;
            }

        totalScore = scoreCurrent;
    }



    /**
     * gets the current user level from the database
     *
     * @return user level (int)
     */
    private int getLevelFromServer(){
        return Integer.parseInt(MainActivity.uLevel);
    }


    /**
     * gets the total score from the database
     *
     * @return total score (int)
     */
    private int getScoreFromServer(){
        return Integer.parseInt(MainActivity.uScore);
    }

    /**
     * updates the total score in the database
     */
    public static void sendScoreToServer(){
        String error = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(ConnectDB.hostName, ConnectDB.adminName, ConnectDB.dbPass);
            Statement statement = connection.createStatement();
            statement.executeQuery("UPDATE user SET user_score = " + totalScore +  " WHERE id = 1");
        }catch (Exception e) {
            error = e.toString();
        }

    }

    /**
     * used for accessing the total score from outside the class
     *
     * @return totalScore (int)
     */
    public int totalScore(){

        return totalScore;

    }

    /**
     * called when the user is done accumulating points. It updates the score and sends it to the
     * database
     *
     * @param points
     */
    public void updateScore( int points ){

        totalScore = points + totalScore;

    }

    /**
     * used for accessing the user level from outside the class
     *
     * @return userLevel (int)
     */
    public int userLevel(){

        return userLevel;

    }
}
