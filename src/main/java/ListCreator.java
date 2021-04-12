import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListCreator {
    public ArrayList<String> groceryArraylist;
    ArrayList<String> namesList = new ArrayList<String>();
    ArrayList<LinkedHashMap<String, ArrayList<String>>> groceryMapList = new ArrayList<LinkedHashMap<String, ArrayList<String>>>();

    public ArrayList<String> getGroceryArraylist() {
        return groceryArraylist;
    }

    public ListCreator(String rawData) {
        groceryArraylist = new ArrayList<String>();
        Pattern groceryPattern = Pattern.compile("name(.*?)##", Pattern.CASE_INSENSITIVE);
        Matcher matcher = groceryPattern.matcher(rawData);
        while (matcher.find()){
            groceryArraylist.add(matcher.group());
        }
    }

    public void groceryMaker(String rawData) {
        groceryArraylist = new ArrayList<String>();
        Pattern groceryPattern = Pattern.compile("name(.*?)##", Pattern.CASE_INSENSITIVE);
        Matcher matcher = groceryPattern.matcher(rawData);
        while (matcher.find()){
            groceryArraylist.add(matcher.group());
        }
    }

    public void makeNamesList() {
        for (int i = 0; i < groceryArraylist.size(); i++) {
            Pattern namePattern = Pattern.compile("name[^A-Z0-9](.*?);", Pattern.CASE_INSENSITIVE);
            Matcher nameMatch = namePattern.matcher(groceryArraylist.get(i));
            int k = 1;
            if (i == 0) {
                while(nameMatch.find()) {
                    namesList.add(nameMatch.group(k));
                }
            } else {
                while (nameMatch.find()) {
                    if (!namesList.contains(nameMatch.group(k))) {
                        namesList.add(nameMatch.group(k));
                    }
                }
            }
            k++;
        }
    }

    public void distinctNames() {
        for (int i = 0; i < namesList.size()-1; i++) {
            if (namesList.get(i).equals("")) {
                namesList.remove(i);
                break;
            }
            for (int j = i+1; j < namesList.size(); j++) {
                if (namesList.get(i).equalsIgnoreCase(namesList.get(j))) {
                    namesList.remove(j);
                }
            }
        }
    }
}
