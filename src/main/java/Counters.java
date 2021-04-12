public class Counters {
    Bread bread = new Bread();
    Milk milk = new Milk();
    Apples apples = new Apples();
    Cookies cookies = new Cookies();
    Errors errors = new Errors();

    public void rackEmUp(String rawData) {
        bread.countName(rawData);
        bread.countPriceOne(rawData);
        milk.countName(rawData);
        milk.countPriceOne(rawData);
        milk.countPriceTwo(rawData);
        apples.countName(rawData);
        apples.countPriceTwo(rawData);
        apples.countPriceTwo(rawData);
        cookies.countName(rawData);
        cookies.countPriceOne(rawData);
    }

    public String tablePrintOut() {
        return milk.printNice() + bread.printNice() + cookies.printNice() + apples.printNice() + errors.printNice();
    }
}
