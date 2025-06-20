package refactoring;

/**
 * Represents a mountain bike with gear system and maximum speed.
 * Features bulk discount for 3+ bikes (10% off).
 */
public class Mountainbike extends Bike {

    /**
     * Creates a new mountain bike.
     */
    public Mountainbike(String productName, double price, int maxSpeed, int rearGearsCount, int frontGearsCount) {
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
     * Calculates base price for mountain bikes.
     * Bulk discount: 10% off for 3+ bikes.
     * @param purchaseAmount the number of bikes to purchase
     * @return the base price with mountain bike discounts
     */
    @Override
    protected double calculateBasePrice(int purchaseAmount) {
        if (purchaseAmount > 2) {
            return purchaseAmount * getPrice() * 0.9;
        } else {
            return getPrice() * purchaseAmount;
        }
    }
}
