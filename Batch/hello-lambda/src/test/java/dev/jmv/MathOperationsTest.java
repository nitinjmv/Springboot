package dev.jmv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MathOperationsTest {

    MathOperations n = new MathOperations();

    @Test
    public void testPlus() {
        int result = n.handler(1, 1, "+");
        assertEquals(2, result);
    }

    @Test
    public void testPlusFail() {
        int result = n.handler(1, 1, "+");
        assertNotEquals(0, result);
    }
}
