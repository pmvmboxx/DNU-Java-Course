import java.text.*;
import java.util.*;
public class Task {
    public static void main(String[] args) {

        double a = -2;
        double b = 3;
        double x = 2.4;

        final Function Task1 = Sum.of(EFunction.of(Multiplication.of(Const.of(a), Exponential.of(Cos.of(X.x()), 2)) ), Multiplication.of(Abs.of(Multiplication.of(Const.of(b),Exponential.of(Ln.of(Exponential.of(X.x(), 0.5)), 5))), Const.of(-1)));
        final Function Task2 = Multiplication.of(Multiplication.of(Const.of(a), Exponential.of(X.x(), 3)), Exponential.of(Exponential.of(Sin.of(Sum.of(X.x(), Const.of(b))), 2),-1));

        final NumberFormat nf = NumberFormat.getInstance();

        System.out.format("f1:").println();
        System.out.format("f1(x) = %s", Task1.toPrettyString(nf)).println();
        System.out.format("f1'(x) = %s", Task1.derivative().toPrettyString(nf)).println();
        System.out.format("f1 (%f) = %f", x, Task1.calculate(x)).println();
        System.out.format("f1'(%f) = %f", x, Task1.derivative().calculate(x)).println();

        System.out.format("f2:").println();
        System.out.format("f2(x) = %s", Task2.toPrettyString(nf)).println();
        System.out.format("f2'(x) = %s", Task2.derivative().toPrettyString(nf)).println();
        System.out.format("f2 (%f) = %f", x, Task2.calculate(x)).println();
        System.out.format("f2'(%f) = %f", x, Task2.derivative().calculate(x)).println();
    }
}
