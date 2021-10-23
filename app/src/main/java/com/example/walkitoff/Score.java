package com.example.walkitoff;

public class Score {

    /*
    For storing, retrieving, and updating the user's total score and level. To be used by sound and
    theme classes to determine which sounds and themes are unlocked.
     */

    // member data
    private int totalScore, userLevel;

    /**
     * default constructor
     */
    public Score(){

    }

    /**
     * calculates the users level
     */
    private void calcLevel(){

    }

    /**
     * gets the current user level from the database
     *
     * @return user level (int)
     */
    private int getLevelFromServer(){

        return 0;
    }

    /**
     * gets the total score from the database
     *
     * @return total score (int)
     */
    private int getScoreFromServer(){

        return 0;
    }

    /**
     * updates the total score in the database
     */
    private void sendScoreToServer(){


    }

    /**
     * used for accessing the total score from outside the class
     *
     * @return totalScore (int)
     */
    public int totalScore(){

        return 0;
    }

    /**
     * called when the user is done accumulating points. It updates the score and sends it to the
     * database
     *
     * @param points
     */
    public void updateScore( int points ){


    }

    /**
     * used for accessing the user level from outside the class
     *
     * @return userLevel (int)
     */
    public int userLevel(){

        return 0;
    }
}
