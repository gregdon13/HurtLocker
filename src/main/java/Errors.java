public class Errors {
    int errorCount;

    public Errors() {
        errorCount = 0;
    }

    public void errorCount() {
        this.errorCount++;
    }

    public String printNice() {
        return "Errors       seen: " + this.errorCount + " times";
    }
}
