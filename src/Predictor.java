import java.util.ArrayList;
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

        List<Map<Integer, Integer>> people = new ArrayList<>();
        
        for(String name: names){
            Map<Integer, Integer> yearToOccurances = new HashMap<>();

            for(Year year: this.data){
                Entry nameEntryInYear = year.getEntries().getEntryByName(name);

                // aparently there were 0 people legally  named "Bob" in the US 2021. Weird
                int occurancesInYear;
                if(nameEntryInYear == null){
                    occurancesInYear = 0;
                }
                else {
                    occurancesInYear = nameEntryInYear.getOccurrences();
                }

                yearToOccurances.put(year.getCalendarYear(), occurancesInYear);
            }

            people.add(yearToOccurances);
        }

        Map<Integer, Integer> yearToMeanOccAllName = new HashMap<>();

        for (Year year : data) { 
            int yearValue = year.getCalendarYear();
            int sum = 0;
            for (Map<Integer, Integer> person : people) {
                sum += person.getOrDefault(yearValue, 0);
            }
            int mean = sum / names.size();
            yearToMeanOccAllName.put(yearValue, mean);
        }



        int bestYear = -1;
        int maxMean = 0;

        for(Map.Entry<Integer, Integer> entry: yearToMeanOccAllName.entrySet()){
            if(entry.getValue() > maxMean){
                bestYear = entry.getKey();
                maxMean = entry.getValue();
            }
        }


        return bestYear;
    }




}
