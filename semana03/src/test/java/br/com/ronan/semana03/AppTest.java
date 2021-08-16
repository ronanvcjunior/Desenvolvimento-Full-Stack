package br.com.ronan.semana03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue( true );
    }

    @Test
    public void testeSoma() {
        int num1 = 1;
        int num2 = 2;
        assertEquals(3, num1 + num2);
    }

    @Test
    public void testeSubtrair() {
        int num1 = 1;
        int num2 = 2;
        assertEquals(-1, num1 - num2);
    }
}
