import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Driver{
    public static void main(String[] args) {

        List<String> names = loadInput(args);

        Predictor p = new Predictor();
        int year = p.predict(names);

        System.out.println("Best predicted year: " + year);
    }

    public static List<String> loadInput(String[] cliArgs){

        String filename = cliArgs[0];

        List<String> names = new LinkedList<>();

        try (Scanner input = new Scanner(new File(filename))) {
            while(input.hasNextLine()){
                names.add(input.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file " + filename);
            System.exit(0);
        }

        return names;
    }

}
