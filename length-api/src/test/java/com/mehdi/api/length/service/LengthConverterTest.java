package com.mehdi.api.length.service;


import com.mehdi.api.length.LengthUnitConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Random;

import static com.mehdi.util.MathUtil.calculateFractionLength;
import static com.mehdi.util.MathUtil.roundTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = com.mehdi.api.length.service.LengthConverterImpl.class)
class LengthConverterTest {

    private static final int DEFAULT_FRACTION = 2;

    @Autowired
    private LengthConverter lengthConverter;

    @Test
    @DisplayName("Test 0 for lengthConverter.meterToFeet()")
    void meterToFeetZero() {
        assertNotNull(lengthConverter, "LengthConverter must not be nell");
        assertEquals(0, lengthConverter.meterToFeet(0), "O m is exactly 0 foot");
    }

    @Test
    @DisplayName("Test random value for lengthConverter.meterToFeet()")
    void meterToFeetRandomValue() {
        double randomValue = new Random().nextDouble();
        double calcValue = lengthConverter.meterToFeet(randomValue);
        assertEquals(roundTo(randomValue / LengthUnitConstants.FEET_TO_METER, DEFAULT_FRACTION), calcValue,
                "calculated value for " + randomValue + " is " + calcValue + " and not valid");
    }

    @Test
    @DisplayName("Test max positive double for lengthConverter.meterToFeet()")
    void meterToFeetMaxPositiveValue() {
        double max = Double.MAX_VALUE;
        double calcValue = lengthConverter.meterToFeet(max);
        assertEquals(roundTo(max / LengthUnitConstants.FEET_TO_METER, 2), calcValue,
                "calculated value for " + max + " is " + calcValue + " and not valid");
    }

    @Test
    @DisplayName("Default fraction must be 2")
    void meterToFeetDefaultFraction() {
        double meter = 10d;
        double calcValue = lengthConverter.meterToFeet(meter);
        assertEquals(DEFAULT_FRACTION, calculateFractionLength(calcValue), "Default fraction for meterToFeet() must be exactly 2");
    }

    @Test
    @DisplayName("Test meter to feet by given fraction")
    void meterToFeetFraction() {
        double meter = 10d;

        for (int numFraction = 0; numFraction < 5; numFraction++) {
            double calcValue = lengthConverter.meterToFeet(meter, numFraction);
            assertEquals(numFraction, calculateFractionLength(calcValue), "Default fraction for meterToFeet() must be exactly " + numFraction);
        }
    }

}