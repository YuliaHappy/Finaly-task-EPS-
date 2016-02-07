package com.epam.javauniversity.eps.range;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RangeTest {
    Range range;

    @Before
    public void initialization() {
        range = new Range(10, 15);
    }

    @Test
    public void initializationTestFalse() {
        try {
            Range range = new Range(15, 10);
            Assert.assertFalse(false);
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void inRangeTestTrue() throws Exception {
        Assert.assertTrue(range.inRange(12));
    }

    @Test
    public void inRangeTestFalse() throws Exception {
        Assert.assertFalse(range.inRange(9));
    }

    @Test
    public void getFromTest() throws Exception {
        Assert.assertEquals(Integer.valueOf(10), range.getFrom());
    }

    @Test
    public void getToTest() throws Exception {
        Assert.assertEquals(Integer.valueOf(15), range.getTo());
    }
}