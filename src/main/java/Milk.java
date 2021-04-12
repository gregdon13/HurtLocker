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

    }

    public void countPriceOne(String rawData) {

    }

    public String printNice() {
        return "name: Milk   seen: " + this.nameCount + " times\n" + "=============   =============\n" +
                "Price:   3.23   seen: " + this.priceCountOne + " times\n" + "-------------   -------------\n" +
                "Price:   1.23   seen: " + this.priceCountTwo + " time\n" + "\n\n";
    }

    public void countPriceTwo(String rawData) {

    }
}
