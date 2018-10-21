package com.mehdi.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MathUtilTest {

    @Test
    @DisplayName("Test calculateFractionLength() for hard-coded values")
    void calculateFractionLength() {
        assertEquals(0, MathUtil.calculateFractionLength(1), "For '1' value fraction is 0");
        assertEquals(1, MathUtil.calculateFractionLength(1.2), "For '1.2' is 1");
        assertEquals(2, MathUtil.calculateFractionLength(5.12), "For '5.12' is 2");
        assertEquals(3, MathUtil.calculateFractionLength(0.123), "For '0.123' is 3");
    }

    @Test
    @DisplayName("Test for Number to N Decimal Places for int values")
    void roundToForInt() {
        assertEquals(0, MathUtil.roundTo(0, 0));
        assertEquals(0, MathUtil.roundTo(0, 1));
        assertEquals(0, MathUtil.roundTo(0, 2));

        assertEquals(1, MathUtil.roundTo(1, 0));
        assertEquals(1, MathUtil.roundTo(1, 1));
        assertEquals(1, MathUtil.roundTo(1, -2));
    }

    @Test
    @DisplayName("Test for Number to N Decimal Places for double values")
    void roundToForDouble() {
        assertEquals(0, MathUtil.roundTo(0.0123, 0));
        assertEquals(0, MathUtil.roundTo(0.0123, 1));
        assertEquals(0.01, MathUtil.roundTo(0.0123, 2));

        assertEquals(1, MathUtil.roundTo(1.12345, 0));
        assertEquals(1.1235, MathUtil.roundTo(1.12345, 4));
        assertEquals(1, MathUtil.roundTo(1.12345, -2));
        assertEquals(1.123, MathUtil.roundTo(1.123, 5));

        assertEquals(1.13, MathUtil.roundTo(1.125, 2));
    }
}