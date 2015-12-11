package pl.kaczor.codility.lessons.counting;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.kaczor.codility.lesssons.counting.MissingInteger;

public class TestMissingInteger {

    @Test
    public void testExample() throws Exception {
        int[] A = {1, 3, 6, 4, 1, 2};
        MissingInteger m = new MissingInteger();
        assertEquals(5, m.solution(A));
    }

    @Test
    public void testAllNegative() throws Exception {
        int[] A = {-1, -5, -2, -7};
        MissingInteger m = new MissingInteger();
        assertEquals(1, m.solution(A));
    }

    @Test
    public void testAllBigPositive() throws Exception {
        int[] A = {5, 2342, 6547567, 7};
        MissingInteger m = new MissingInteger();
        assertEquals(1, m.solution(A));
    }

    @Test
    public void testAllLarge() throws Exception {
        int[] A = {2_147_483_647, 2_147_483_643, 2_147_483_645, -2_147_483_647, -2_147_483_642};
        MissingInteger m = new MissingInteger();
        assertEquals(1, m.solution(A));
    }

    @Test
    public void testPermutation() throws Exception {
        int[] A = {5, 2, 4, 1, 6, 3};
        MissingInteger m = new MissingInteger();
        assertEquals(7, m.solution(A));
    }
}
