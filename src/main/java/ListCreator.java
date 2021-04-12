import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListCreator {
    public ArrayList<String> groceryArraylist;
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
}
