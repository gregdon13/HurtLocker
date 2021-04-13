import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Counter {
    String output = "";
    MapMaker mapMaker = new MapMaker();

    public Counter() throws Exception {
    }

    public void countInstances() throws Exception {
        for (LinkedHashMap<String, ArrayList<String>> l : mapMaker.listCreator.groceryMapList) {
            int nameCount = 0;
            String name = l.get("Name").get(0).toLowerCase();
            String name1 = "";
            if (name.matches("[a-zA-Z]+")) {
                name1 += name.substring(0, 1).toUpperCase() + name.substring(1);
            } else {
                break;
            }
            String priceOne = l.get("Price").get(0);
            String priceTwo = "";
            int priceCountOne = 0;
            int priceCountTwo = 0;
            for (String s : l.get("Name")) {
                nameCount++;
            }
            for (String str : l.get("Price")) {
                if (str.equals(priceOne)) {
                    priceCountOne++;
                } else if (str.equals(priceTwo)){
                    priceCountTwo++;
                }else {
                    priceTwo += str;
                    priceCountTwo++;
                }
            }
            if (priceTwo.equals("")) {
                output += "Name: " + name1 + "   seen: " + nameCount + " times\n"
                        + "=========================\n" + "Price: " + priceOne + "   seen: " + priceCountOne + " times\n"
                        + "-------------------------\n\n";
            } else {
                //catches when there is a price two
                output += "Name: " + name1 + "   seen: " + nameCount + " times\n"
                        + "=========================\n" + "Price: " + priceOne + "   seen: " + priceCountOne + " times\n"
                        + "-------------------------\n"
                        + "Price: " + priceTwo + "  seen: " + priceCountTwo + " times\n\n";
            }
        }
        output += "Errors       seen: " + countErrors() + " times";
    }

    public int countErrors() throws Exception {
        int errorCounter = 0;
        Pattern errorPattern = Pattern.compile("[^a-zA-Z0-9];");
        Matcher errorMatcher = errorPattern.matcher(mapMaker.main.readRawDataToString());
        while(errorMatcher.find()) {
            errorCounter++;
        }
        return errorCounter;
    }
}
