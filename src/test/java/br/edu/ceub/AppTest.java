package br.edu.ceub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    void somarDoisETresRetornaCinco() {
        App appunderTest = new App();
        int result = appunderTest.somar(2, 3);
        assertEquals(5, result);
    }
    
    @Test
    void somarPositivos() {
        App appunderTest = new App();
        int result = appunderTest.somar(10, 10);
        assertEquals(20, result);
    }
    @Test
    void somarWithZero() {
        App appunderTest = new App();
        int result = appunderTest.somar(10, 0);
        assertEquals(10, result);
    }

    @Test
    void somarFailWithBigInts() {
        App appunderTest = new App();
        int numeroGrande = 2147483647;
        int result = appunderTest.somar(numeroGrande,numeroGrande);
        assertEquals(-2, result);
    }

}
