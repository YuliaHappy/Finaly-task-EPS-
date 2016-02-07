package com.epam.javauniversity.eps.parser;

import com.epam.javauniversity.eps.input.Input;

public class Parser {
    public Input parse(String[] args) {
        if (args == null || args.length != 3) {
            throw new IllegalArgumentException("false size command line");
        }
        try {
            Integer width = Integer.parseInt(args[0]);
            Integer height = Integer.parseInt(args[1]);
            Double fieldFactor = Double.parseDouble(args[2]);
            return new Input(width, height, fieldFactor);
        } catch (NumberFormatException e) {
            return new Input(0, 0, (double) 0);
        }
    }
}
