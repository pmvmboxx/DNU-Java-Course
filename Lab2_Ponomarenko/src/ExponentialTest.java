import org.junit.jupiter.api.Test;
import java.text.NumberFormat;

import static org.junit.jupiter.api.Assertions.*;

public class ExponentialTest {

    @Test
    void calculate() {
        Function innerF = new X();
        Exponential exponential = new Exponential(innerF, 2);
        double result = exponential.calculate(2);
        assertEquals(4, result);
    }

    @Test
    void derivative() {
        Function innerF = new X();
        Exponential exp = new Exponential(innerF, 2);
        Function derivative = exp.derivative();
        double result = derivative.calculate(-2);
        assertEquals(4, result);
    }

    @Test
    void toPrettyString() {
        Function innerF = new X();
        Exponential exponential = new Exponential(innerF, 2);
        NumberFormat nf = NumberFormat.getInstance();
        String prettyString = exponential.toPrettyString(nf);
        assertEquals("x^2", prettyString);
    }

    @Test
    void of() {
        Function innerF = new X();
        Exponential exponential = Exponential.of(innerF, 2);
        assertNotNull(exponential);
    }
}