import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MapMaker {
    Main main = new Main();
    ListCreator listCreator = new ListCreator(main.readRawDataToString());

    public MapMaker() throws Exception {
        mapMaker();
    }

    public void mapMaker() {
        for (int i = 0; i < listCreator.groceryArraylist.size(); i++) {
            Pattern namePattern = Pattern.compile("name[^A-Z0-9]([a-z].*?);", Pattern.CASE_INSENSITIVE);
            Matcher matcher = namePattern.matcher(listCreator.groceryArraylist.get(i));
            Pattern pricePattern = Pattern.compile("price[^A-Z0-9]([0-9]*?\\.[0-9][0-9])", Pattern.CASE_INSENSITIVE);
            Matcher priceMatcher = pricePattern.matcher(listCreator.getGroceryArraylist().get(i));
                while(matcher.find() && priceMatcher.find()) {
                    if (listCreator.groceryMapList.isEmpty()) {
                        addToEmptyMap(matcher, priceMatcher);
                    } else {
                        //catches if list of maps is NOT empty
                        addToExistingMap(matcher, priceMatcher);
                    }
                }
        }
    }

    public void addToEmptyMap(Matcher matcher, Matcher priceMatcher) {
        Grocery grocery = new Grocery();
        grocery.groceryMap.get("Name").add(matcher.group(1));
        grocery.groceryMap.get("Price").add(priceMatcher.group(1));
        listCreator.groceryMapList.add(grocery.groceryMap);
    }

    public void addToExistingMap(Matcher matcher, Matcher priceMatcher) {
        boolean addAGrocery = true;
        for (int j = 0; j < listCreator.groceryMapList.size(); j++) {
            //I did do a string method here. I know. But wasn't sure how else to make this so general
            String result = matcher.group(1).replaceAll("\\B0|0\\B", "o");
            if (result.equalsIgnoreCase(listCreator.groceryMapList.get(j).get("Name").get(0))) {
                listCreator.groceryMapList.get(j).get("Name").add(matcher.group(1));
                listCreator.groceryMapList.get(j).get("Price").add(priceMatcher.group(1));
                addAGrocery = false;
            }
        }
        if (addAGrocery) {
            addToEmptyMap(matcher, priceMatcher);
        }
    }

}
