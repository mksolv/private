package pl.kaczor.codility.lessons.counting;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.kaczor.codility.lesssons.counting.FrogRiverOne;

public class TestFrogRiverOne {
    @Test
    public void testExample() throws Exception {
        int[] A = { 1, 3, 1, 4, 2, 3, 5, 4 };
        FrogRiverOne f = new FrogRiverOne();
        assertEquals(6, f.solution(5, A));
    }

    @Test
    public void testOneElement() throws Exception {
        int[] A = { 1 };
        FrogRiverOne f = new FrogRiverOne();
        assertEquals(0, f.solution(1, A));
    }

    @Test
    public void testNotExist() throws Exception {
        int[] A = { 1, 3, 1, 3, 2, 3, 5, 2 };
        FrogRiverOne f = new FrogRiverOne();
        assertEquals(-1, f.solution(5, A));
    }

    @Test
    public void testReverseBig() throws Exception {
        int[] A = { 6, 5, 4, 3, 2, 1 };
        FrogRiverOne f = new FrogRiverOne();
        assertEquals(5, f.solution(6, A));

    }
}
