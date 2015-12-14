package pl.kaczor.codility.lessons.prefsums;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pl.kaczor.codility.lesssons.prefsums.CountDiv;

public class TestCountDiv {

    private CountDiv obj;

    @Before
    public void setUp() {
        obj = new CountDiv();
    }

    @Test
    public void testExample() throws Exception {
        assertEquals(3, obj.solution(6,  11,  2));
        assertEquals(20, obj.solution(11,  345,  17));
        assertEquals(2, obj.solution(11,  14,  2));
        assertEquals(12345, obj.solution(101,  123_456_789,  10_000));
    }

    @Test
    public void testEqual() throws Exception {
        assertEquals(1, obj.solution(4,  4,  2));
        assertEquals(0, obj.solution(5,  5,  2));
        assertEquals(1, obj.solution(0,  0,  456));
    }

    @Test
    public void testLarge() throws Exception {
        assertEquals(2, obj.solution(0, 1_999_999_999,  1_000_000_000));
        assertEquals(0, obj.solution(1, 1_999_999_999,  2_000_000_000));
    }
}
