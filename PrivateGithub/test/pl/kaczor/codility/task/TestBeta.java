package pl.kaczor.codility.task;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBeta {

    private Beta obj;

    @Before
    public void setUp() throws Exception {
        this.obj = new Beta();
    }

    @Test
    public void testExample() {
        assertEquals(11, obj.solution(new int[]{1, 5, 2, 1, 4, 0}));
    }

    @Test
    public void testEmpty() throws Exception {
        assertEquals(0, obj.solution(new int[]{}));
    }

    @Test
    public void testSingleElem() throws Exception {
        assertEquals(0, obj.solution(new int[]{5}));
    }

    @Test
    public void testTwoElements() throws Exception {
        assertEquals(0, obj.solution(new int[]{0, 0}));
        assertEquals(1, obj.solution(new int[]{1, 1}));
        assertEquals(1, obj.solution(new int[]{1, 0}));
        assertEquals(1, obj.solution(new int[]{0, 1}));
    }

    @Test
    public void testThreeElements() throws Exception {
        assertEquals(3, obj.solution(new int[]{1, 1, 1}));
        assertEquals(0, obj.solution(new int[]{0, 0, 0}));
        assertEquals(2, obj.solution(new int[]{0, 1, 0}));
        assertEquals(3, obj.solution(new int[]{1, 0, 1}));
    }

    @Test
    public void testDifficult() throws Exception {
        assertEquals(5, obj.solution(new int[]{2, 0, 0, 2}));
        assertEquals(3, obj.solution(new int[]{2, 1, 1}));
        assertEquals(3, obj.solution(new int[]{2, 0, 1}));
        assertEquals(5, obj.solution(new int[]{2, 0, 0, 2}));
    }

    @Test
    public void testArithmeticOverflow() throws Exception {
        assertEquals(2, obj.solution(new int[]{1, 2147483647, 0}));
    }
}
