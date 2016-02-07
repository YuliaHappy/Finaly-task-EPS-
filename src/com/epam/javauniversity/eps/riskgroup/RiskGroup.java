package com.epam.javauniversity.eps.riskgroup;

import com.epam.javauniversity.eps.range.Range;

public class RiskGroup {
    private final String name;
    private final Range range;

    public RiskGroup(String name, Range range) {
        this.name = name;
        this.range = range;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RiskGroup riskGroup = (RiskGroup) o;

        if (name != null ? !name.equals(riskGroup.name) : riskGroup.name != null) return false;
        if (range != null ? !range.equals(riskGroup.range) : riskGroup.range != null) return false;

        return true;
    }

    public String getName() {
        return name;
    }

    public Range getRange() {
        return range;
    }
}
