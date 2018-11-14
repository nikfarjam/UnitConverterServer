package com.mehdi.util;

public class MathUtil {

    public static int calculateFractionLength(double value) {
        long num = Math.round(value);
        double diff = value - num;
        if (diff == 0) {
            return 0;
        }
        String str = "" + value;
        return str.length() - str.indexOf('.') - 1;
    }

    public static double roundTo(double value, int numFraction) {
        int place = (numFraction > 0) ? numFraction : 0;
        double scale = Math.pow(10, place);
        return Math.round(value * scale) / scale;
    }
}
