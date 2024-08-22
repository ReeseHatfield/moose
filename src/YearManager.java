import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class YearManager {

    private static final String DATA_PATH = "data/";

    public static List<Year> loadData() {

        List<Year> years = new LinkedList<>();

        File dir = new File(DATA_PATH);
        File[] yobFiles = dir.listFiles();


        for(File f: yobFiles){
            int calendarYear = stripCalendarYear(f); 
            Year curYear = new Year(f, calendarYear);

            years.add(curYear);
        }

        return years;
    }

    public static int stripCalendarYear(File f){
        String name = f.getName();
        String trimed = name.replaceAll("yob", "").replace(".txt", "");

        return Integer.parseInt(trimed);

    }
}


