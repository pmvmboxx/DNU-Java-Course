import java.text.NumberFormat;

public class Const implements Function {
    public static final Const ZERO = new Const(0);

    private final double value;

    public Const(double value) {

        this.value = value;
    }
    @Override
    public double calculate(double x) {
        return value;
    }
    @Override
    public Function derivative() {
        return ZERO;
    }
    @Override
    public String toPrettyString(NumberFormat nf) {
        return nf.format(value);
    }

    public static Const of(double value) {  //фабричний метод, який повертає новий екземпляр класу зі значенням
        return new Const(value);
    }
}

