package com.epam.javauniversity.eps.input;

public class Input {
    private final Integer width;
    private final Integer height;
    private final Double fieldFactor;

    public Input(Integer width, Integer height, Double fieldFactor) {
        this.width = width;
        this.height = height;
        this.fieldFactor = fieldFactor;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public Double getFieldFactor() {
        return fieldFactor;
    }
}
