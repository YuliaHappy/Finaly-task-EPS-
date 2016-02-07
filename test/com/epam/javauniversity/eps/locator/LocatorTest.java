package com.epam.javauniversity.eps.locator;

import com.epam.javauniversity.eps.range.Range;
import com.epam.javauniversity.eps.riskgroup.RiskGroup;
import com.epam.javauniversity.eps.sector.Sector;
import com.epam.javauniversity.eps.sector.cell.CellState;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class LocatorTest {
    List<RiskGroup> possibleGroups;
    Map<RiskGroup, Integer> groups;

    @Before
    public void initialization() throws Exception {
        Sector sector = new Sector(2,3);
        sector.setCellState(0,0, CellState.HUMAN);
        sector.setCellState(0,1,CellState.EMPTY);
        sector.setCellState(0,2,CellState.HUMAN);
        sector.setCellState(1,0,CellState.EMPTY);
        sector.setCellState(1,1,CellState.HUMAN);
        sector.setCellState(1,2,CellState.HUMAN);
        possibleGroups = Arrays.asList(new RiskGroup("NONE", new Range(1, 2)), new RiskGroup("MINOR", new Range(3, 4)),
                new RiskGroup("NORMAL", new Range(5, 7)));
        Locator locator = new Locator(possibleGroups);
        groups = locator.searchForEmergencies(sector);
    }

    @Test
    public void testSearchForEmergenciesSize() throws Exception {
        assertEquals(2, groups.size());
    }

    @Test
    public void testSearchForEmergenciesFirstItem() throws Exception {
        assertEquals(Integer.valueOf(1), groups.get(possibleGroups.get(0)));
    }

    @Test
    public void testSearchForEmergenciesSecondItem() throws Exception {
        assertEquals(Integer.valueOf(1), groups.get(possibleGroups.get(1)));
    }

    @Test
    public void testSearchForEmergenciesNotItem() throws Exception {
        assertFalse(groups.containsKey(possibleGroups.get(2)));
    }
}