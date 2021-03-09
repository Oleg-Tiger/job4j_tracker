package ru.job4j.oop;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class PointTest extends TestCase {

    @Test
    public void testDistance() {
        Point a = new Point(2, 5);
        Point b = new Point(5, 10);
        double expected = 5.83;
        double rsl = a.distance(b);
Assert.assertEquals(expected, rsl, 0.01);
    }

    @Test
    public void testDistance3d() {
        Point a = new Point(2, 4, 6);
        Point b = new Point(0, 1, 10);
        double rsl = a.distance3d(b);
        double expected = 5.385;
        Assert.assertEquals(expected, rsl, 0.01);
    }
}