import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.Year;
import data.Entry;
import data.YearManager;

public class Predictor {

    private List<Year> data;
    
    // list of names need input here or sum
    public Predictor(){
        this.data = YearManager.loadData();
    }

    public int predict(List<String> names){

        
        for(String name: names){
            Map<Integer, Integer> yearToOccurances = new HashMap<>();

            for(Year year: this.data){
                Entry nameEntryInYear = year.getEntries().getEntryByName(name);
                yearToOccurances.put(year.getCalendarYear(), nameEntryInYear.getOccurrences());
            }

            System.out.println(yearToOccurances);
        }

        return 0;
    }




}
