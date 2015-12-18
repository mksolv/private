package pl.kaczor.codility.lessons.prefsums;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pl.kaczor.codility.lesssons.prefsums.GenomicRangeQuery;

public class TestGenomicRangeQuery {

    GenomicRangeQuery obj;

    @Before
    public void setUp() throws Exception {
        this.obj = new GenomicRangeQuery();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testExample() {
        assertArrayEquals(new int[] { 2, 4, 1 }, obj.solution("CAGCCTA", new int[] { 2, 5, 0 }, new int[] { 4, 5, 6 }));
    }

    @Test
    public void testSingleElement() {
        assertArrayEquals(new int[] { 2, 2 }, obj.solution("C", new int[] { 0, 0 }, new int[] { 0, 0 }));
    }

    @Test
    public void testLarge() {
        char[] tab = new char[100000];
        Arrays.fill(tab, 'G');
        tab[0] = 'A';
        tab[99999] = 'T';
        assertArrayEquals(new int[] { 1, 3, 4, 1, 1, 1, 3 }, obj.solution(String.valueOf(tab),
                new int[] { 0, 1, 99999, 0, 0, 0, 1 },
                new int[] { 0, 1, 99999, 1, 2, 99999, 1000 }));
    }
}
