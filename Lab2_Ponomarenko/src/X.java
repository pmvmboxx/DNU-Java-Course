import java.text.NumberFormat; //клас для форматування чисел у вигляді рядків

public class X implements Function {

    public X() {

    }
    @Override
    public double calculate(double x) {
        return x;
    }
    @Override
    public String toPrettyString(NumberFormat nf) {
        return "x";
    }
    @Override
    public Function derivative() {
        return new Const(1);
    }

    public static X x() { //дозволяє створювати об'єкти без необхідності явно викликати конструктор
        return new X();
    }
}
