package pl.kaczor.codility.lessons.counting;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.kaczor.codility.lesssons.counting.MaxCounters;

public class TestMaxCounters {
    @Test
    public void testExample() throws Exception {
        int[] input = { 3, 4, 4, 6, 1, 4, 4 };
        int[] output = { 3, 2, 2, 4, 2 };
        MaxCounters m = new MaxCounters();
        assertArrayEquals(output, m.solution(5, input));
    }

    @Test
    public void testSingle() throws Exception {
        int[] input = { 1 };
        int[] output = { 1 };
        MaxCounters m = new MaxCounters();
        assertArrayEquals(output, m.solution(1, input));
    }

    @Test
    public void testMaximizeOnFinish() throws Exception {
        int[] input = { 1, 1, 4 };
        int[] output = { 2, 2, 2 };
        MaxCounters m = new MaxCounters();
        assertArrayEquals(output, m.solution(3, input));
    }
}
