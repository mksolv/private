package pl.kaczor;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMain {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testMain() {
        assertEquals("test", "test");
        int i = 0;
        assertEquals(i, 0);
    }

}
