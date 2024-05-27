import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.StringJoiner; //використовується для об'єднання рядків з роздільником

public class Multiplication extends Composite{
    public Multiplication() {
        super();
    }
    public Multiplication(Function... terms) { //приймає змінну кіл-ь ф-й
        super(terms);
    }
    public Multiplication(ArrayList<Function> terms) {
        super(terms);
    }
    @Override
    public double calculate(double x) {
        double result = 1;
        for (Function function : terms()) {
            result *= function.calculate(x);
        }
        return result; //повертає добуток значень
    }
    @Override
    public Function derivative() { //обчислює похідну
        int counter = 0;
        final ArrayList<Function> derivativeTerms = new ArrayList<>(terms().size()); //створення списку, куди додаватиметься частинний добуток після обчисл похідної
        for (int i = 0; i < terms().size(); i++) {
            ArrayList<Function> temp = new ArrayList<>(terms().size());
            int j = 0; //індекс елемента списку
            boolean isZero = false;
            for (Function function : terms()) {
                if(counter == j) temp.add(function.derivative()); //в temp додається похідна,якщо індекс дорівнює counter
                else temp.add(function);
                if (temp.get(j++) == Const.ZERO) isZero = true; //перевірка чи дорівнює поточний елемент нульовій константі
            }
            if(!isZero) derivativeTerms.add(Multiplication.of(temp)); //якщо не містить 0 константи, то додається у список derivativeTerms
            counter++;

        }

        return new Sum(derivativeTerms); //gповертає суму частинни добутків
    }
    @Override
    public String toPrettyString(NumberFormat nf) {
        final StringJoiner joiner = new StringJoiner("*"); //об'єднує рядки з роздільником "*"
        for (Function function : terms()) {
            joiner.add(function.toPrettyString(nf)); //для кожної ф-ії викликається метод і перетворює у рядок
        }
        return String.format("(%s)",joiner.toString()); //повертається загальний рядок
    }
    public static Multiplication of(Function... terms) { //ств новий об'єкт класу з функціями як аргументи
        return new Multiplication(terms);
    }

    public static Multiplication of(ArrayList<Function> terms) { //ств новий об'єкт класу з функціями в списку
        return new Multiplication(terms);
    }
}
