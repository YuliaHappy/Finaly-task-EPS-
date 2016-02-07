package com.epam.javauniversity.eps;

import com.epam.javauniversity.eps.input.Input;
import com.epam.javauniversity.eps.locator.Locator;
import com.epam.javauniversity.eps.parser.Parser;
import com.epam.javauniversity.eps.range.Range;
import com.epam.javauniversity.eps.reporter.Reporter;
import com.epam.javauniversity.eps.riskgroup.RiskGroup;
import com.epam.javauniversity.eps.sector.Sector;
import com.epam.javauniversity.eps.sector.source.RandomFillSectorSource;
import com.epam.javauniversity.eps.sector.source.SectorSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws CloneNotSupportedException {
        Parser parser = new Parser();
        Input input = parser.parse(args);
        SectorSource areaSource = new RandomFillSectorSource(input.getWidth(), input.getHeight(), input.getFieldFactor());
        Sector sector = areaSource.getSector();
        List<RiskGroup> possibleRiskGroup = getPossibleRiskGroup();
        Locator locator = new Locator(possibleRiskGroup);
        Map<RiskGroup, Integer> emergencies = locator.searchForEmergencies(sector);
        Reporter reporter = new Reporter();
        System.out.println(reporter.createReporter(sector, emergencies, input.getFieldFactor(), possibleRiskGroup));
    }

    private static List<RiskGroup> getPossibleRiskGroup() {
        return Arrays.asList(new RiskGroup("NONE", new Range(1, 2)), new RiskGroup("MINOR", new Range(3, 4)),
                new RiskGroup("NORMAL", new Range(5, 7)), new RiskGroup("MAJOR", new Range(8, 13)),
                new RiskGroup("CRITICAL", new Range(14)));
    }
}
