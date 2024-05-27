import java.text.NumberFormat;
import static java.lang.Math.*;

public class Cos implements Function {

    private final Function InnerF; //зберігає внутрішню ф-ю, яка буде виокристовуватися як аргумент для ф-ії косинуса

    public Cos(Function InnerF) {
        this.InnerF = InnerF;
    }
    @Override
    public double calculate(double x) {
        return cos(InnerF.calculate(x)); //обчисл InnerF для x і повертає косинус цього значення
    }
    @Override
    public Function derivative() {
        return Multiplication.of(Const.of(-1), Sin.of(InnerF), InnerF.derivative());
    }
    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("cos(%s)", InnerF.toPrettyString(nf));
    }

    public static Cos of(Function InnerF) {
        return new Cos(InnerF);
    }
}
