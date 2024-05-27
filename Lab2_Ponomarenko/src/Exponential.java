import java.text.NumberFormat;//клас для форматування чисел у вигляді рядків


import static java.lang.Math.*;


public class Exponential implements Function {

    private final double power; //зберігає показник степеня
    private final Function InnerF; //зберігає внутрішню функцію, яка буде пвднесена до степеня power

    public Exponential(Function InnerF, double power) {
        this.power = power;
        this.InnerF = InnerF;
    }
    @Override
    public double calculate(double x) {
        return pow(InnerF.calculate(x),power);
    }
    @Override
    public Function derivative() {
        if (power - 1 == 1) return Multiplication.of(Const.of(power), InnerF, InnerF.derivative());
        if (power - 1 == 0) return InnerF.derivative();
        return Multiplication.of(Const.of(power), Exponential.of(InnerF, power-1), InnerF.derivative());
    }
    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("%s^%s", InnerF.toPrettyString(nf), nf.format(power));
    }
    public static Exponential of(Function InnerF, double power) {
        return new Exponential(InnerF, power);
    }
}
