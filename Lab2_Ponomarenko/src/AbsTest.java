import org.junit.jupiter.api.Test;
import java.text.NumberFormat;

import static org.junit.jupiter.api.Assertions.*;

public class AbsTest {

    @Test
    void calculate() {
        Function innerF = new X();
        Sin sin = new Sin(innerF);
        double result = sin.calculate(-0.5);
        assertEquals(Math.sin(-0.5), result);
    }

    @Test
    void derivative() {
        Function innerF = new X();
        Abs abs = new Abs(innerF);
        Function derivative = abs.derivative();
        assertTrue(derivative instanceof Multiplication);
    }

    @Test
    void toPrettyString() {
        Function innerF = new X();
        Abs abs = new Abs(innerF);
        NumberFormat nf = NumberFormat.getInstance();
        String prettyString = abs.toPrettyString(nf);
        assertEquals("|x|", prettyString);
    }

    @Test
    void of() {
        Function innerF = new X();
        Abs abs = Abs.of(innerF);
        assertNotNull(abs);
    }
}