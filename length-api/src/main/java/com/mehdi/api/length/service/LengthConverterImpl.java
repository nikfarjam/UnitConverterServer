package com.mehdi.api.length.service;

import com.mehdi.util.MathUtil;
import org.springframework.stereotype.Service;

import static com.mehdi.api.length.LengthUnitConstants.FEET_TO_METER;

@Service
public class LengthConverterImpl implements LengthConverter {

    private static final int DEFAULT_FRACTION = 2;

    @Override
    public double meterToFeet(double meter) {
        return meterToFeet(meter, DEFAULT_FRACTION);
    }

    @Override
    public double meterToFeet(double meter, int fraction) {
        return MathUtil.roundTo(meter / FEET_TO_METER, fraction);
    }
}
