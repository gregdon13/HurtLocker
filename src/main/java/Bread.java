public class Bread implements Groceries{
    int nameCount;
    int priceCount;

    public Bread() {
        this.nameCount = 0;
        this.priceCount = 0;
    }

    public void countName(String rawData) {

    }

    public void countPriceOne(String rawData) {

    }

    public String printNice() {
        return "name:   Bread   seen: " + this.nameCount + " times\n" + "=============   =============\n" +
                "Price:   1.23   seen: " + this.priceCount + " times\n" + "-------------   -------------\n\n";
    }
}
