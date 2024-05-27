import java.text.NumberFormat;
import static java.lang.Math.*;
public class Ln implements Function{

    private final Function InnerF;

    public Ln(Function InnerF) {
        this.InnerF = InnerF;
    }

    @Override
    public double calculate(double x) {
        double InnerResult = InnerF.calculate(x);
        if (InnerResult<=0){
            return Double.NaN; // логарифм від від'ємного числа або нуля недійсний
        }
            return log(InnerResult); //обчислення натурального логарифму
    }

    @Override
    public Function derivative() {
        return new Multiplication(InnerF.derivative(), new Exponential(InnerF, -1));
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return "ln(" + InnerF.toPrettyString(nf) + ")";
    }

    public static Ln of(Function InnerF) { //фабричний метод
        return new Ln(InnerF);
    }
}
