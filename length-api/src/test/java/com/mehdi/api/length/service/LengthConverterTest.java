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
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
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
        assertThat("O m is exactly 0 foot", lengthConverter.meterToFeet(0), is(0d));
    }

    @Test
    @DisplayName("Test random value for lengthConverter.meterToFeet()")
    void meterToFeetRandomValue() {
        double randomValue = new Random().nextDouble();
        double calcValue = lengthConverter.meterToFeet(randomValue);
        assertThat("calculated value for " + randomValue + " is " + calcValue + " and not valid",
                roundTo(randomValue / LengthUnitConstants.FEET_TO_METER, DEFAULT_FRACTION), is(calcValue));
    }

    @Test
    @DisplayName("Test max positive double for lengthConverter.meterToFeet()")
    void meterToFeetMaxPositiveValue() {
        double max = Double.MAX_VALUE;
        double calcValue = lengthConverter.meterToFeet(max);
        assertThat("calculated value for " + max + " is " + calcValue + " and not valid",
                roundTo(max / LengthUnitConstants.FEET_TO_METER, 2), is(calcValue)
        );
    }

    @Test
    @DisplayName("Default fraction must be 2")
    void meterToFeetDefaultFraction() {
        double meter = 10d;
        double calcValue = lengthConverter.meterToFeet(meter);
        assertThat("Default fraction for meterToFeet() must be exactly 2",
                calculateFractionLength(calcValue), is(DEFAULT_FRACTION));
    }

    @Test
    @DisplayName("Test meter to feet by given fraction")
    void meterToFeetFraction() {
        double meter = 10d;

        for (int numFraction = 0; numFraction < 5; numFraction++) {
            double calcValue = lengthConverter.meterToFeet(meter, numFraction);
            assertThat("Default fraction for meterToFeet() must be exactly " + numFraction,
                    calculateFractionLength(calcValue), is(numFraction));
        }
    }

}