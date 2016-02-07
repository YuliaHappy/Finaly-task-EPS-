package com.epam.javauniversity.eps.range;

public class Range {
    private final Integer from;
    private final Integer to;

    public Range(Integer from) {
        this.from = from;
        this.to = Integer.MAX_VALUE;
    }

    public Range(Integer from, Integer to) {
        if (to < from) {
            throw new IllegalArgumentException();
        }
        this.from = from;
        this.to = to;
    }

    public boolean inRange(Integer value) {
        return value <= to && value >= from;
    }

    public Integer getFrom() {
        return from;
    }

    public Integer getTo() {
        return to;
    }
}
