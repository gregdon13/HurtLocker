import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Errors {
    int errorCount = 0;

    public Errors() {}

    public void errorCount(String rawData) {
        Pattern errorPattern = Pattern.compile("name:;|price:;", Pattern.CASE_INSENSITIVE);
        Matcher errorMatcher = errorPattern.matcher(rawData);
        while (errorMatcher.find()) {
            this.errorCount++;
        }
    }

    public String printNice() {
        return "Errors       seen: " + this.errorCount + " times";
    }
}
