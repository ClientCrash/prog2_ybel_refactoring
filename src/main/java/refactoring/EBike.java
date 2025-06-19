package refactoring;

/**
 * Represents an electric bike with battery, gear system and maximum speed.
 */
public class EBike extends Bike {

    private int maxSpeed;
    private int rearGearsCount;
    private int frontGearsCount;

    /**
     * Creates a new electric bike.
     */
    public EBike(String productName, double price, int maxSpeed, int rearGearsCount, int frontGearsCount, int batteryCapacity) {
        setProductName(productName);
        setPrice(price);
        setBatteryCapacity(batteryCapacity);
        this.maxSpeed = maxSpeed;
        this.rearGearsCount = rearGearsCount;
        this.frontGearsCount = frontGearsCount;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public int getGearsCount() {
        return rearGearsCount * frontGearsCount;
    }
}
