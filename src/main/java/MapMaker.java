import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MapMaker {
    Main main = new Main();
    String output = "";
    ListCreator listCreator = new ListCreator(main.readRawDataToString());

    public MapMaker() throws Exception {
    }


    public void mapMaker() {
        for (String s : listCreator.getGroceryArraylist()) {
            Grocery grocery = new Grocery();
            Pattern namePattern = Pattern.compile("name[^A-Z0-9](.*?);", Pattern.CASE_INSENSITIVE);
            Matcher matcher = namePattern.matcher(s);
            while(matcher.find()) {
                grocery.groceryMap.get("Name").add(matcher.group(1));
            }
            Pattern pricePattern = Pattern.compile("price[^A-Z0-9](([0-9]*?)\\.[0-9][0-9])");
            Matcher priceMatcher = pricePattern.matcher(s);
            while(priceMatcher.find()){
                grocery.groceryMap.get("Price").add(priceMatcher.group(1));
            }
            listCreator.groceryMapList.add(grocery.groceryMap);
        }
    }
}
