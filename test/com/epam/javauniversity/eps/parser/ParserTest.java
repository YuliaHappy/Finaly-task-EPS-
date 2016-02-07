package com.epam.javauniversity.eps.parser;

import com.epam.javauniversity.eps.input.Input;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
    Parser parser;
    Input input;

    @Before
    public void initialization() {
        parser = new Parser();
        input = parser.parse(new String[]{"5", "7", "0.6"});
    }

    @Test
    public void testParseWidth() throws Exception {
        Assert.assertEquals(Integer.valueOf(5), input.getWidth());
    }

    @Test
    public void testParseHeight() throws Exception {
        Assert.assertEquals(Integer.valueOf(7), input.getHeight());
    }

    @Test
    public void testParseFieldFactor() throws Exception {
        Assert.assertEquals(Double.valueOf(0.6), input.getFieldFactor());
    }
}