import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MultiplicationTest {

    @Test
    void calculate() {
        Function f1 = new Const(2);
        Function f2 = new X();
        Multiplication multiplication = new Multiplication(f1, f2);
        double result = multiplication.calculate(3);
        assertEquals(6, result);
    }

    @Test
    void derivative() {
        Function f1 = new Const(2);
        Function f2 = new X();
        Multiplication multiplication = new Multiplication(f1, f2);
        Function derivative = multiplication.derivative(); // d/dx(2x) = 2
        assertTrue(derivative instanceof Const);
        assertEquals(2, derivative.calculate(0));
    }

    @Test
    void toPrettyString() {
        Function f1 = new Const(2);
        Function f2 = new X();
        Multiplication multiplication = new Multiplication(f1, f2);
        NumberFormat nf = NumberFormat.getInstance();
        String prettyString = multiplication.toPrettyString(nf);
        assertEquals("(2*x)", prettyString);
    }

    @Test
    void testMultiplicationOfArray() {
        Function f1 = new Const(2);
        Function f2 = new X();
        Multiplication multiplication = Multiplication.of(f1, f2);
        assertNotNull(multiplication);
    }

    @Test
    void testMultiplicationOfList() {
        Function f1 = new Const(2);
        Function f2 = new X();
        ArrayList<Function> functions = new ArrayList<>();
        functions.add(f1);
        functions.add(f2);
        Multiplication multiplication = Multiplication.of(functions);
        assertNotNull(multiplication);
    }
}