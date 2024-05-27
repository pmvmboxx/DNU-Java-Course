import java.util.ArrayList; //для створення динамічних масивів
import java.util.Arrays;

public abstract class Composite implements Function {

    private final ArrayList<Function> terms; //зберігає список функцій,які складають композитну ф-ю

    public ArrayList<Function> terms() { //повертає список ф-й
        return terms;
    }

    public Composite() {
        terms = new ArrayList<>();
    }

    public Composite(Function... terms) { //приймає невизначену кіль-ть ф-й і ініціалізує списком, створеним з масиву
        this.terms = new ArrayList<>(Arrays.asList(terms));
    }

    public Composite(ArrayList<Function> terms) {
        this.terms = terms;
    }
}