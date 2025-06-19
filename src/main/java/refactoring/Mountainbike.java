package refactoring;

/**
 * Represents a mountain bike with gear system and maximum speed.
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
}
