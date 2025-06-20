package refactoring;

/**
 * Represents a Brompton folding bike with gear system and maximum speed.
 * Features special pricing: additional bikes at half price.
 */
public class Brompton extends Bike {

    /**
     * Creates a new Brompton folding bike.
     */
    public Brompton(String productName, double price, int maxSpeed, int rearGearsCount, int frontGearsCount) {
        setProductName(productName);
        setPrice(price);
        setMaxSpeed(maxSpeed);
        setRearGearsCount(rearGearsCount);
        setFrontGearsCount(frontGearsCount);
    }

    @Override
    public Integer getBatteryCapacity() {
        return null;
    }

    /**
     * Calculates base price for Brompton bikes.
     * Special offer: all bikes at full price + additional bikes at half price.
     * @param purchaseAmount the number of bikes to purchase
     * @return the base price with Brompton pricing
     */
    @Override
    protected double calculateBasePrice(int purchaseAmount) {
        double price = getPrice() * purchaseAmount;
        if (purchaseAmount > 1) {
            price += (purchaseAmount - 1) * getPrice() / 2;
        }
        return price;
    }
}
