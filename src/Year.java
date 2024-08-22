import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Year {
    private List<Entry> entries;
    private final String TOKEN = ",";
    private final int calendarYear;

    public Year(File yobFile, int calendarYear){
        this.entries = createEntries(yobFile);
        this.calendarYear = calendarYear;
    }

    public int getCalendarYear(){
        return this.calendarYear;
    }

    private List<Entry> createEntries(File yobFile){

        List<Entry> entries = new LinkedList<>();

        try (Scanner fileScanner = new Scanner(yobFile)) {
            int rank = 1;
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(TOKEN);

                String name = parts[0];
                Sex s = Sex.valueOf(parts[1]);
                int occurances = Integer.parseInt(parts[2]);
                Entry entry = new Entry(rank, name, s, occurances);

                entries.add(entry);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return entries;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.calendarYear + ": \n");

        sb.append(this.entries);
        return sb.toString();
    }



}
