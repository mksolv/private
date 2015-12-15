package pl.kaczor.codility.lessons.prefsums;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pl.kaczor.codility.lesssons.prefsums.MinAvgTwoSlice;

public class TestMinAvgTwoSlice {

    private MinAvgTwoSlice obj;

    @Before
    public void setUp() {
        this.obj = new MinAvgTwoSlice();
    }

    @Test
    public void testExample() throws Exception {
        assertEquals(1, obj.solution(new int[] {4, 2, 2, 5, 1, 5, 8}));
        assertEquals(5, obj.solution(new int[] {10, 10, -1, 2, 4, -1, 2, -1}));
    }

    @Test
    public void testMyExamples() throws Exception {
        assertEquals(0, obj.solution(new int[] {1, 7, 9, 0, 10, 8, 2}));
        assertEquals(1, obj.solution(new int[] {3, 1, 2, 3, 1}));
        assertEquals(4, obj.solution(new int[] {4, 4, 4, -2, 4, -10}));
    }

    @Test
    public void testNegative() throws Exception {
        assertEquals(2, obj.solution(new int[] {-3, -5, -8, -4, -10}));
    }
}
