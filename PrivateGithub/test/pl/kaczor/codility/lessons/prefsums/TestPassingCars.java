package pl.kaczor.codility.lessons.prefsums;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pl.kaczor.codility.lesssons.prefsums.PassingCars;

public class TestPassingCars {

    private PassingCars obj;

    @Before
    public void setUp() throws Exception {
        this.obj = new PassingCars();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testExample() {
        assertEquals(5, obj.solution(new int[]{0,1,0,1,1}));
    }

}
