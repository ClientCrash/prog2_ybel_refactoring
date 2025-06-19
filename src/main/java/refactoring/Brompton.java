package refactoring;

/**
 * Represents a Brompton folding bike with gear system and maximum speed.
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
}
