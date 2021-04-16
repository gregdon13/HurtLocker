import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Grocery {
    LinkedHashMap<String, ArrayList<String>> groceryMap = new LinkedHashMap<String, ArrayList<String>>();

    public Grocery(){
        groceryMap.put("Name", new ArrayList<String>());
        groceryMap.put("Price", new ArrayList<String>());
    }
}
