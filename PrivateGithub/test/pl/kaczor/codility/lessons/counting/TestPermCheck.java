package pl.kaczor.codility.lessons.counting;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.kaczor.codility.lesssons.counting.PermCheck;

public class TestPermCheck {

    @Test
    public void testExample() {
        int[] A = {4, 1, 3, 2};
        PermCheck p = new PermCheck();
        assertEquals(1, p.solution(A));
    }

    @Test
    public void testExample2() {
        int[] A = {4, 1, 3};
        PermCheck p = new PermCheck();
        assertEquals(0, p.solution(A));
    }

    @Test
    public void testOneElem() {
        int[] A = {3};
        PermCheck p = new PermCheck();
        assertEquals(0, p.solution(A));
    }

    @Test
    public void testOneElem2() {
        int[] A = {1};
        PermCheck p = new PermCheck();
        assertEquals(1, p.solution(A));
    }
}
