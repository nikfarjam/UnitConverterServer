package com.mehdi.api.length.model;

import java.util.Objects;

public class LengthResponse {

    private Double value;

    private String unit;

    private String message;

    public LengthResponse(Double value, String unit, String message) {
        this.value = value;
        this.unit = unit;
        this.message = message;
    }

    public Double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LengthResponse that = (LengthResponse) o;
        return Objects.equals(value, that.value) &&
                Objects.equals(unit, that.unit) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit, message);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("LengthResponse{");
        sb.append("value=").append(value);
        sb.append(", unit='").append(unit).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
