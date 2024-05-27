import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.StringJoiner; //використовується для об'єднання рядків з роздільником

public class Sum extends Composite {

    public Sum() {
        super();
    }
    public Sum(Function... terms) { //приймає змінну кіл-ь ф-й
        super(terms);
    }
    public Sum(ArrayList<Function> terms) { //приймає список функцій
        super(terms);
    }
    @Override
    public double calculate(double x) {
        double result = 0.0;
        for (Function function : terms()) { //foreach
            result += function.calculate(x);
        }
        return result;
    }
    @Override
    public Function derivative() { //обчислює похідну для кожної ф-ії у списку
        final ArrayList<Function> derivativeTerms = new ArrayList<>(terms().size());
        for (Function function : terms()) {
            derivativeTerms.add(function.derivative());
        }
        return new Sum(derivativeTerms);
    }
    @Override
    public String toPrettyString(NumberFormat nf) {
        final StringJoiner joiner = new StringJoiner("+");
        for (Function function : terms()) {
            joiner.add(function.toPrettyString(nf));
        }
        return String.format("(%s)",
                joiner.toString()).replace("+-", "-");
    }
    public static Sum of(Function... terms) { //фабричний метод
        return new Sum(terms);
    }
}
