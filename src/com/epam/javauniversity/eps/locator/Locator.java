package com.epam.javauniversity.eps.locator;

import com.epam.javauniversity.eps.riskgroup.RiskGroup;
import com.epam.javauniversity.eps.sector.Sector;
import com.epam.javauniversity.eps.sector.cell.CellState;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Locator {
    private final List<RiskGroup> riskGroup;
    private Sector locationSector;

    public Locator(List<RiskGroup> possibleRiskGroup) {
        riskGroup = possibleRiskGroup;
    }

    public Map<RiskGroup, Integer> searchForEmergencies(Sector sector) throws CloneNotSupportedException {
        locationSector = sector.clone();
        Map<RiskGroup, Integer> emergencies = new HashMap<>();
        for (int x = 0; x < locationSector.getWidth(); x++) {
            for (int y = 0; y < locationSector.getHeight(); y++) {
                if (locationSector.getCellState(x, y) == CellState.HUMAN) {
                    Integer sizeGroup = searchGroup(x, y);
                    addToGroup(emergencies, sizeGroup);
                }
            }
        }
        return emergencies;
    }

    private void addToGroup(Map<RiskGroup, Integer> emergencies, Integer sizeGroup) {
        for (RiskGroup group : riskGroup) {
            if (group.getRange().inRange(sizeGroup)) {
                if (emergencies.containsKey(group)) {
                    emergencies.put(group, emergencies.get(group) + 1);
                } else {
                    emergencies.put(group, 1);
                }
                break;
            }
        }
    }

    private Integer searchGroup(int xParent, int yParent) {
        locationSector.setCellState(xParent, yParent, CellState.EMPTY);
        Integer countSubGroup = 1;
        countSubGroup += getCountSubGroup(xParent, yParent - 1);        //Левый элемент
        countSubGroup += getCountSubGroup(xParent - 1, yParent);        //Верхний элемент
        countSubGroup += getCountSubGroup(xParent, yParent + 1);        //Правый элемент
        countSubGroup += getCountSubGroup(xParent + 1, yParent);        //Нижний элемент
        return countSubGroup;
    }

    private Integer getCountSubGroup(int x, int y) {
        try {
            if (locationSector.getCellState(x, y) == CellState.HUMAN) {
                 return searchGroup(x, y);
            }
        } catch (IllegalArgumentException ignore) {
        }
        return 0;
    }
}
