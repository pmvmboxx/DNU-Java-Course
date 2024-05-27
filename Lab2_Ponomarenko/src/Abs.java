import java.text.NumberFormat;
import static java.lang.Math.*;

public class Abs implements Function {

    private final Function InnerF; //внутрішня функція, для якої обчислюється модуль

    public Abs(Function InnerF) {
        this.InnerF = InnerF;
    }
    @Override
    public double calculate(double x) {
        return abs(InnerF.calculate(x)); //повертає модуль значення, обчисленого InnerF для x
    }
    @Override
    public Function derivative() { //обчислення похідної

        return Multiplication.of(InnerF, Exponential.of(Abs.of(InnerF), -1), InnerF.derivative());
    }
    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("|%s|", InnerF.toPrettyString(nf));
    }
    public static Abs of(Function InnerF) { //фабричний метод
        return new Abs(InnerF);
    }
}
