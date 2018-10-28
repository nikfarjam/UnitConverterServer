package com.mehdi.api.length.service;

import com.mehdi.api.length.controller.LengthConverterController;
import com.mehdi.api.length.model.LengthResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.mehdi.api.length.LengthUnitConstants.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class LengthConverterControllerTest {

    @Mock
    private LengthConverter lengthConverter;

    @InjectMocks
    private LengthConverterController lengthController;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Nested
    @DisplayName("Mock tests for lengthConverter.meterToFeet()")
    class MeterToFeet {

        @DisplayName("Normal return value of meterToFeet()")
        @Test
        void meterToFeet() {
            var testValue = 10d;
            var expectedResult = 32.808d;
            when(lengthConverter.meterToFeet(testValue, 3)).thenReturn(expectedResult);

            LengthResponse response = lengthController.meterToFeet(testValue, 3);

            assertThat(response.getValue(), is(expectedResult));
            assertThat(response.getUnit(), is(UNIT_FEET));
            assertThat(response.getMessage(), is(MESSAGE_SUCCESS));

            verify(lengthConverter, times(1)).meterToFeet(testValue, 3);
        }

        @DisplayName("meterToFeet() for null meter")
        @Test
        void meterToFeetForNull() {
            LengthResponse response = lengthController.meterToFeet(null, 3);

            assertThat(response.getValue(), is(nullValue()));
            assertThat(response.getUnit(), is(UNIT_FEET));
            assertThat(response.getMessage(), is(MESSAGE_INVALID_INPUT));

            verify(lengthConverter, never()).meterToFeet(anyDouble(), anyInt());
        }
    }
}
