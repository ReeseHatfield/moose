import java.util.List;

import data.Year;
import data.YearManager;

public class Predictor {
    

    // list of names
    public Predictor(){
        List<Year> data = YearManager.loadData();

        System.out.println(data.get(0));
    }


}
