package com.example.walkitoff;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ScoreTest {

    @Test
    void updateScore() {
        Score score = new Score();
        double intended = 350;
        double add =  score.totalScore();
        assertEquals(350, add + intended);
    }

    @Test
    void totalScore(){

    }
}