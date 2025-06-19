package refactoring;

/**
 * Represents a Brompton folding bike with gear system and maximum speed.
 */
public class Brompton extends Bike {

    private int maxSpeed;
    private int rearGearsCount;
    private int frontGearsCount;

    /**
     * Creates a new Brompton folding bike.
     */
    public Brompton(String productName, double price, int maxSpeed, int rearGearsCount, int frontGearsCount) {
        setProductName(productName);
        setPrice(price);
        this.maxSpeed = maxSpeed;
        this.rearGearsCount = rearGearsCount;
        this.frontGearsCount = frontGearsCount;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public Integer getBatteryCapacity() {
        return null;
    }

    @Override
    public int getGearsCount() {
        return rearGearsCount * frontGearsCount;
    }
}
