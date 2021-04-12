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


    public void mapMaker2() {
        for (String s : listCreator.getGroceryArraylist()) {
            Pattern namePattern = Pattern.compile("name[^A-Z0-9](.*?);", Pattern.CASE_INSENSITIVE);
            Matcher matcher = namePattern.matcher(s);
                while(matcher.find()) {
                    for (int i = 0; i < listCreator.groceryMapList.size(); i++) {
                        if (i == 0) {
                            Grocery grocery = new Grocery();
                            listCreator.groceryMapList.add(grocery.groceryMap);
                            listCreator.groceryMapList.get(i).get("Name").add(matcher.group(1));
                        }

//                        else if (matcher.group().equals(listCreator.groceryMapList.get(i).get("Name").get(0))) {
//                            listCreator.groceryMapList.get(i).get("Name").add(matcher.group(1));
//                        }
                    }
                }
            Grocery grocery = new Grocery();
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

    public void mapMaker() {
        for (int i = 0; i < listCreator.groceryArraylist.size(); i++) {
            Pattern namePattern = Pattern.compile("name[^A-Z0-9](.*?);", Pattern.CASE_INSENSITIVE);
            Matcher matcher = namePattern.matcher(listCreator.groceryArraylist.get(i));
            Pattern pricePattern = Pattern.compile("price[^A-Z0-9]([0-9]*?\\.[0-9][0-9])");
            Matcher priceMatcher = pricePattern.matcher(listCreator.getGroceryArraylist().get(i));
                while(matcher.find() && priceMatcher.find()) {
                    if (listCreator.groceryMapList.isEmpty()) {
                        Grocery grocery = new Grocery();
                        grocery.groceryMap.get("Name").add(matcher.group(1));
                        grocery.groceryMap.get("Price").add(priceMatcher.group(1));
                        listCreator.groceryMapList.add(grocery.groceryMap);
                    } else {
                        //catches if list of maps is NOT empty

                    }
                }
        }
    }
}
