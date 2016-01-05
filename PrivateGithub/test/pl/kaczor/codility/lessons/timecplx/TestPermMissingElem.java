package pl.kaczor.codility.lessons.timecplx;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pl.kaczor.codility.lesssons.timecplx.PermMissingElem;
import pl.kaczor.utils.IntUtils;

public class TestPermMissingElem {

    PermMissingElem obj;

    @Before
    public void setUp() throws Exception {
        obj = new PermMissingElem();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testExample() {
        assertEquals(4, obj.solution(new int[] { 2, 3, 1, 5 }));
    }

    @Test
    public void testSingle() {
        assertEquals(2, obj.solution(new int[] { 1 }));
        assertEquals(1, obj.solution(new int[] { 2 }));
    }

    @Test
    public void testLarge() throws Exception {
        int[] largeArray = IntUtils.getConsecutiveIntArray(99999, 1);
        assertEquals(100000, obj.solution(largeArray));

        largeArray = IntUtils.getConsecutiveIntArray(99999, 2);
        assertEquals(1, obj.solution(largeArray));
    }
}
