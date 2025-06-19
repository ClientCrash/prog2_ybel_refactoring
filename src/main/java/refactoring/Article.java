package refactoring;

/**
 * Represents an article with a bike and purchase amount.
 */
public class Article {

    private Bike bike;
    private int purchaseAmount;

    /**
     * Creates a new article.
     * @param bike the bike
     * @param purchaseAmount the amount to purchase
     */
    public Article(Bike bike, int purchaseAmount) {
        this.bike = bike;
        this.purchaseAmount = purchaseAmount;
    }

    public Bike getBike() {
        return bike;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
