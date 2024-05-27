import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

import static org.junit.jupiter.api.Assertions.*;

public class SinTest {

    @Test
    void testCalculate() {
        Function innerF = new X();
        Sin sin = new Sin(innerF);
        double res = sin.calculate(Math.PI / 2);
        assertEquals(1, res, 0.0001);
    }

    @Test
    void testDerivative() {
        Function innerF = new X();
        Sin sin = new Sin(innerF);
        Function derivative = sin.derivative();
        assertTrue(derivative instanceof Cos);
    }

    @Test
    void testToPrettyString() {
        Function innerF = new X();
        Sin sin = new Sin(innerF);
        NumberFormat nf = NumberFormat.getInstance();
        String prettyString = sin.toPrettyString(nf);
        assertEquals("sin(x)", prettyString);
    }

    @Test
    void testOf() {
        Function innerF = new X();
        Sin sin = Sin.of(innerF);
        assertNotNull(sin);
    }
}