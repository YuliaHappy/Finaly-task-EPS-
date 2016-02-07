package com.epam.javauniversity.eps.sector.source;


import com.epam.javauniversity.eps.sector.Sector;
import com.epam.javauniversity.eps.sector.cell.CellState;

import java.util.Random;

public class RandomFillSectorSource implements SectorSource {
    private Sector sector;
    Random random = new Random();
    public RandomFillSectorSource(Integer width, Integer height, Double fieldFactor) {
        if (fieldFactor < 0) {
            throw new IllegalArgumentException("");
        }
        sector = new Sector(width, height);
        fillSector(fieldFactor);
    }

    private void fillSector(Double fieldFactor) {
        for (int x = 0; x < sector.getWidth(); x++) {
            for (int y =0; y < sector.getHeight(); y++) {
                fillFieldCell(fieldFactor, x, y);
            }
        }
    }

    private void fillFieldCell(Double fieldFactor, int x, int y) {
        if (random.nextDouble() <= fieldFactor) {
            sector.setCellState(x, y, CellState.HUMAN);
        } else {
            sector.setCellState(x, y, CellState.EMPTY);
        }
    }

    @Override
    public Sector getSector() {
        return sector;
    }
}
