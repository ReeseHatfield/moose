import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import cli.ANSI;
import cli.CLI;

public class Driver {


    public static void main(String[] args) {
        if (args.length == 0) {

            CLI.printColorLn(ANSI.RED, "Error: No input file provided.");
            CLI.printColorLn(ANSI.RED, "Usage:", "./moose.sh <filename>");
            System.exit(1);
        }

        CLI.printColorLn(ANSI.GREEN, "Welcome to the Moose CLI!");
        
        CLI.printColorLn(ANSI.GREEN, "Loading input...");
        List<String> names = loadInput(args);
        CLI.printColorLn(ANSI.GREEN, "Input loaded successfully!");

        CLI.printColorLn(ANSI.BLUE, "Predicting the best year range...");


        Predictor p = new Predictor();

        int year = p.predict(names);

        CLI.printColorLn(ANSI.BLUE, "========================================");
        CLI.printColorLn(ANSI.BLUE, "Best predicted year:", Integer.toString(year), " - ", Integer.toString(year + 5));
        CLI.printColorLn(ANSI.BLUE, "========================================");

    }

    public static List<String> loadInput(String[] cliArgs) {
        String filename = cliArgs[0];
        List<String> names = new LinkedList<>();

        try (Scanner input = new Scanner(new File(filename))) {
            while (input.hasNextLine()) {
                names.add(input.nextLine());
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            CLI.printColorLn(ANSI.RED, "Error: Could not find file ", filename);
            System.exit(1);
        }

        return names;
    }
}
