import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cookies implements Groceries{
    int nameCount;
    int priceCount;

    public Cookies() {
        this.nameCount = 0;
        this.priceCount = 0;
    }

    public void countName(String rawData) {
        Pattern pricePattern = Pattern.compile("name[^A-Za-z0-9]c[0|O][0|O]kies", Pattern.CASE_INSENSITIVE);
        Matcher priceMatcher = pricePattern.matcher(rawData);
        while (priceMatcher.find()) {
            nameCount++;
        }
    }

    public void countPriceOne(String rawData) {
        Pattern pricePattern = Pattern.compile("name[^A-Za-z0-9]c[o|0][0|O]kies;price[^A-Za-z0-9]2.25", Pattern.CASE_INSENSITIVE);
        Matcher priceMatcher = pricePattern.matcher(rawData);
        while (priceMatcher.find()) {
            priceCount++;
        }
    }

    public String printNice() {
        return "name: Cookies   seen: " + this.nameCount + " times\n" + "=============   =============\n" +
                "Price:   2.25   seen: " + this.priceCount + " times\n" + "-------------   -------------\n\n";
    }
}
