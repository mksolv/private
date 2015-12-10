package pl.kaczor;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import pl.kaczor.utils.IntUtils;

public class TestTapeEquilibrium {

    private int[] increment10 = IntUtils.getConsecutiveIntArray(10, 1);
    private int[] incrementMinusToPlus1000 = IntUtils.getConsecutiveIntArray(2001, -1000);
    private int[] example = {3, 1, 2, 4, 3};
    private int[] maxAll = new int[100000];

    @Test
    public void testSolutionIncrement10() throws Exception {
        assertEquals(1, TapeEquilibrium.solution(increment10));
    }

    @Test
    public void testSolutionIncrementMinusToPlus1000() throws Exception {
        assertEquals(2000, TapeEquilibrium.solution(incrementMinusToPlus1000));
    }

    @Test
    public void testSolutionReversedIncrement10() throws Exception {
        assertEquals(1, TapeEquilibrium.solution(IntUtils.reverseArray(increment10)));
    }

    @Test
    public void testSolution() throws Exception {
        assertEquals(1, TapeEquilibrium.solution(example));
    }

    @Test
    public void testSolutionTwo() throws Exception {
        assertEquals(1, TapeEquilibrium.solution(new int[]{1, 2}));
    }

    @Test
    public void testSolutionXl() throws Exception {
        Arrays.fill(maxAll, 1000);
        assertEquals(0, TapeEquilibrium.solution(maxAll));
    }
}
