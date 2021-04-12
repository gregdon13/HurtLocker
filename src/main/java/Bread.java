import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bread implements Groceries{
    int nameCount;
    int priceCount;

    public Bread() {
        this.nameCount = 0;
        this.priceCount = 0;
    }

    public void countName(String rawData) {
        Pattern nameMatch = Pattern.compile("name:bread", Pattern.CASE_INSENSITIVE);
        Matcher nameMatcher = nameMatch.matcher(rawData);
        while (nameMatcher.find()) {
            nameCount++;
        }
    }

    public void countPriceOne(String rawData) {
        Pattern pricePattern = Pattern.compile("price:1.23", Pattern.CASE_INSENSITIVE);
        Matcher priceMatcher = pricePattern.matcher(rawData);
        while (priceMatcher.find()) {
            priceCount++;
        }
    }

    public String printNice() {
        return "name:   Bread   seen: " + this.nameCount + " times\n" + "=============   =============\n" +
                "Price:   1.23   seen: " + this.priceCount + " times\n" + "-------------   -------------\n\n";
    }
}
