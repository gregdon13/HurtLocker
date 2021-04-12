import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Milk implements Groceries{
    int nameCount;
    int priceCountOne;
    int priceCountTwo;

    public Milk() {
        this.nameCount = 0;
        this.priceCountOne = 0;
        this.priceCountTwo = 0;
    }

    public void countName(String rawData) {
        Pattern nameMatch = Pattern.compile("name[^A-Za-z0-9]milk;price[^A-Za-z0-9][0-9]", Pattern.CASE_INSENSITIVE);
        Matcher nameMatcher = nameMatch.matcher(rawData);
        while (nameMatcher.find()) {
            nameCount++;
        }
    }

    public void countPriceOne(String rawData) {
        Pattern pricePattern = Pattern.compile("name[^A-Za-z0-9]milk;price[^A-Za-z0-9]3\\.23", Pattern.CASE_INSENSITIVE);
        Matcher priceMatcher = pricePattern.matcher(rawData);
        while (priceMatcher.find()) {
            priceCountOne++;
        }
    }

    public String printNice() {
        return "name:    Milk   seen: " + this.nameCount + " times\n" + "=============   =============\n" +
                "Price:   3.23   seen: " + this.priceCountOne + " times\n" + "-------------   -------------\n" +
                "Price:   1.23   seen: " + this.priceCountTwo + " time\n" + "\n\n";
    }

    public void countPriceTwo(String rawData) {
        Pattern pricePattern = Pattern.compile("name[^A-Za-z0-9]milk;price[^A-Za-z0-9]1\\.23", Pattern.CASE_INSENSITIVE);
        Matcher priceMatcher = pricePattern.matcher(rawData);
        while (priceMatcher.find()) {
            priceCountTwo++;
        }
    }
}
