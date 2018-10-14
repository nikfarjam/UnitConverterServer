package com.mehdi.api.length.service;

import org.springframework.stereotype.Service;

import static com.mehdi.api.length.LengthUnitConstants.FEET_TO_METER;

@Service
public class LengthConverterImpl implements LengthConverter {
    @Override
    public double meterToFeet(double meter) {
        return meter / FEET_TO_METER;
    }
}
