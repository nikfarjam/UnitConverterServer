package com.mehdi.api.length.service;


import com.mehdi.api.length.LengthUnitConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = com.mehdi.api.length.service.LengthConverterImpl.class)
class LengthConverterTest {

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
        assertEquals(randomValue / LengthUnitConstants.FEET_TO_METER, calcValue,
                "calculated value for " + randomValue + " is " + calcValue + " and not valid");
    }

    @Test
    @DisplayName("Test max positive double for lengthConverter.meterToFeet()")
    void meterToFeetMaxPositiveValue() {
        double max = Double.MAX_VALUE;
        double calcValue = lengthConverter.meterToFeet(max);
        assertEquals(max / LengthUnitConstants.FEET_TO_METER, calcValue,
                "calculated value for " + max + " is " + calcValue + " and not valid");
    }

}