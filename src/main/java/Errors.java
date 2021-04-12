import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Errors {
    int errorCount;

    public Errors() {
        this.errorCount = 0;
    }

    public void errorCount(String rawData) {
        Pattern errorPattern = Pattern.compile("name[^A-Za-z0-9];|price[^A-Za-z0-9];", Pattern.CASE_INSENSITIVE);
        Matcher errorMatcher = errorPattern.matcher(rawData);
        while (errorMatcher.find()) {
            this.errorCount++;
        }
    }

    public String printNice() {
        return "Errors       seen: " + this.errorCount + " times";
    }
}
