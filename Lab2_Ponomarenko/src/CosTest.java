import org.junit.jupiter.api.Test;
import java.text.NumberFormat;

import static org.junit.jupiter.api.Assertions.*;

class CosTest {

    @Test
    void testCosCalculate() {
        Function innerF = new X();
        Cos cos = new Cos(innerF);
        double result = cos.calculate(Math.PI);
        assertEquals(-1, result);
    }

    @Test
    void testCosDerivative() {
        Function innerF = new X();
        Cos cos = new Cos(innerF);
        Function derivative = cos.derivative();
        double result = derivative.calculate(Math.PI / 2);
        assertEquals(-1, result);
    }

    @Test
    void testCosToPrettyString() {
        Function innerF = new X();
        Cos cos = new Cos(innerF);
        NumberFormat nf = NumberFormat.getInstance();
        String prettyString = cos.toPrettyString(nf);
        assertEquals("cos(x)", prettyString);
    }

    @Test
    void testCosOf() {
        Function innerF = new X();
        Cos cos = Cos.of(innerF);
        assertNotNull(cos);
    }
}