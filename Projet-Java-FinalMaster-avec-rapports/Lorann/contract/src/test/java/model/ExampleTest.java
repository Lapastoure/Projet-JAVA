package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExampleTest {
    private Example example;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        this.example = new Example(1,1,10);
    }

    @Test
    public void testGetX() {
        final int expected = 1;
        assertEquals(expected, this.example.getX());
    }

    @Test
    public void testGetY() {
    	final int expected = 1;
        assertEquals(expected, this.example.getY());
    }

    @Test
    public void testGetIdSprite() {
    	final int expected = 10;
        assertEquals(expected, this.example.getIdSprite());
    }

}
