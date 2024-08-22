import java.util.Arrays;

public class Driver{
    public static void main(String[] args) {
        Predictor p = new Predictor();
        int year = p.predict(Arrays.asList("Bob", "Alice", "Charlie"));

        System.out.println("Best predicted year: " + year);
    }
}
