import java.text.NumberFormat;

public interface Function {
    double calculate(double x); //обчислює значення функції

    Function derivative(); //повертає похідну

    String toPrettyString(NumberFormat nf); //повертає форматований рядок
}