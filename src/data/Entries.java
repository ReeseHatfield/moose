package data;

import java.util.ArrayList;


public class Entries extends ArrayList<Entry> {
    
    public Entry getEntryByName(String name){
        for(Entry e: this){
            if(e.getName().equals(name)){
                return e;
            }
        }

        return null;
    }
}
