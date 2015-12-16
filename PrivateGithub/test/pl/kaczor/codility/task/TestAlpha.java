package pl.kaczor.codility.task;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pl.kaczor.utils.IntUtils;

public class TestAlpha {

    private Alpha obj;

    @Before
    public void setUp() throws Exception {
        this.obj = new Alpha();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testExample() {
        assertEquals(3, obj.solution(new int[]{2, 2, 1, 0, 1}));
        assertEquals(4, obj.solution(new int[]{2, 2, 1, 0, 3}));
    }

    @Test
    public void testSingleElement() throws Exception {
        assertEquals(0, obj.solution(new int[]{0}));
    }

    @Test
    public void testLarge() throws Exception {
        int[] tab = IntUtils.getConsecutiveIntArray(1_000_000);
        assertEquals(999_999, obj.solution(tab));
        tab = IntUtils.reverseArray(tab);
        assertEquals(999_999, obj.solution(tab));
    }

}
