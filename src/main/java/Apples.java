import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Apples implements Groceries{
    int nameCount;
    int priceCountOne;
    int priceCountTwo;

    public Apples() {
        this.nameCount = 0;
        this.priceCountOne = 0;
        this.priceCountTwo = 0;
    }

    //Regex based
    public void countName(String rawData) {
        Pattern nameMatch = Pattern.compile("name[^A-Za-z0-9]apples", Pattern.CASE_INSENSITIVE);
        Matcher nameMatcher = nameMatch.matcher(rawData);
        while (nameMatcher.find()) {
            nameCount++;
        }
    }

    public void countPriceOne(String rawData) {
        Pattern pricePattern = Pattern.compile("name[^A-Za-z0-9]apples;price[^A-Za-z0-9]0.25", Pattern.CASE_INSENSITIVE);
        Matcher priceMatcher = pricePattern.matcher(rawData);
        while (priceMatcher.find()) {
            priceCountOne++;
        }
    }

    public String printNice() {
        return "name:  Apples   seen: " + this.nameCount + " times\n" + "=============   =============\n" +
                "Price:   0.25   seen: " + this.priceCountOne + " times\n" + "-------------   -------------\n" +
                "Price:   0.23   seen: " + this.priceCountTwo + " time\n" + "\n\n";
    }

    public void countPriceTwo(String rawData) {
        Pattern pricePattern = Pattern.compile("name:apples;price:0.23", Pattern.CASE_INSENSITIVE);
        Matcher priceMatcher = pricePattern.matcher(rawData);
        while (priceMatcher.find()) {
            priceCountTwo++;
        }
    }
}
