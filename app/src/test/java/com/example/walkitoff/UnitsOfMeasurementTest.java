package com.example.walkitoff;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnitsOfMeasurementTest {

    @Test
    void toFeet() {
        UnitsOfMeasurement feet = new UnitsOfMeasurement();
        assertEquals(3.208, feet.toFeet(1));
    }
}