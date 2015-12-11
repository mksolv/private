package pl.kaczor;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFrogJmp {
    @Test
    public void testSolutionExample() throws Exception {
        assertEquals(FrogJmp.solution(10, 85, 30), 3);
    }

    @Test
    public void testMultiplication() throws Exception {
        assertEquals(FrogJmp.solution(10, 90, 20), 4);
    }

    @Test
    public void testXEqualsY() throws Exception {
        assertEquals(FrogJmp.solution(500, 500, 100), 0);
    }

    @Test
    public void testExtreme() throws Exception {
        assertEquals(FrogJmp.solution(1, 1000000000, 1), 999999999);
        assertEquals(FrogJmp.solution(1, 1000000000, 3), 333333333);
        assertEquals(FrogJmp.solution(1, 1000000000, 4), 250000000);
        assertEquals(FrogJmp.solution(23423423, 1000000000, 1000000000), 1);
    }
}

