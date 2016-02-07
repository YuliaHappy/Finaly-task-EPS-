package com.epam.javauniversity.eps.sector;

import com.epam.javauniversity.eps.sector.cell.CellState;

public class Sector implements Cloneable {
    private CellState[][] sector;
    public Sector(Integer width, Integer height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("");
        }
        sector = new CellState[width][height];
    }

    public int getWidth() {
        return sector.length;
    }

    public int getHeight() {
        return sector[0].length;
    }

    public void setCellState(int x, int y, CellState cellState) throws IllegalArgumentException {
        if (x < 0 || x  >= getWidth() || y < 0 || y >= getHeight()) {
            throw  new IllegalArgumentException();
        }
        sector[x][y] = cellState;
    }

    public CellState getCellState(int x, int y) throws IllegalArgumentException {
        if (x < 0 || x  >= getWidth() || y < 0 || y >= getHeight()) {
            throw new IllegalArgumentException();
        }
        return sector[x][y];
    }

    @Override
    public Sector clone() throws CloneNotSupportedException {
        Sector cloneSector = (Sector) super.clone();
        cloneSector.sector = new CellState[getWidth()][getHeight()];
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                cloneSector.setCellState(i, j, getCellState(i, j));
            }
        }
        return cloneSector;
    }
}
