import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Grocery {
    String name;
    String price;
//    String type;
//    String expiration;
    LinkedHashMap<String, ArrayList<String>> groceryMap = new LinkedHashMap<String, ArrayList<String>>();
    ArrayList<String> numOfTimes;

    public Grocery(){
        groceryMap.put("Name", new ArrayList<String>());
        groceryMap.put("Price", new ArrayList<String>());
//        groceryMap.put("Type", new ArrayList<String>());
//        groceryMap.put("Expiration", new ArrayList<String>());
    }
}
