import java.text.NumberFormat;
import static java.lang.Math.*;
public class EFunction implements Function {
    private final Function exponent;

    public EFunction(Function exponent) {
        this.exponent = exponent;
    }

    @Override
    public double calculate(double x) {
        double exponentValue = exponent.calculate(x);
        return exp(exponentValue);
    }

    @Override
    public Function derivative() {
        // Похідна експоненційної функції exp(x) є сама собою
        return new EFunction(exponent);
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return "e^(" + exponent.toPrettyString(nf) + ")";
    }

    public static EFunction of(Function exponent) {
        return new EFunction(exponent);
    }
}
