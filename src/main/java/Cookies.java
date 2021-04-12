public class Cookies implements Groceries{
    int nameCount;
    int priceCount;

    public Cookies() {
        this.nameCount = 0;
        this.priceCount = 0;
    }

    public void countName(String rawData) {

    }

    public void countPriceOne(String rawData) {

    }

    public String printNice() {
        return "name: Cookies   seen: " + this.nameCount + " times\n" + "=============   =============\n" +
                "Price:   2.25   seen: " + this.priceCount + " times\n" + "-------------   -------------\n\n";
    }
}
