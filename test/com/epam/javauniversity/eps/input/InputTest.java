package com.epam.javauniversity.eps.input;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InputTest {
    Input input;

    @Before
    public void initialization() {
        input = new Input(5, 7, 0.6);
    }

    @Test
    public void testGetWidth() throws Exception {
        Assert.assertEquals(Integer.valueOf(5), input.getWidth());
    }

    @Test
    public void testGetHeight() throws Exception {
        Assert.assertEquals(Integer.valueOf(7), input.getHeight());
    }

    @Test
    public void testGetFieldFactor() throws Exception {
        Assert.assertEquals(Double.valueOf(0.6), input.getFieldFactor());
    }
}