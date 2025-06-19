package refactoring;

/**
 * Represents an electric bike with battery, gear system and maximum speed.
 */
public class EBike extends Bike {

    /**
     * Creates a new electric bike.
     */
    public EBike(String productName, double price, int maxSpeed, int rearGearsCount, int frontGearsCount, int batteryCapacity) {
        setProductName(productName);
        setPrice(price);
        setMaxSpeed(maxSpeed);
        setRearGearsCount(rearGearsCount);
        setFrontGearsCount(frontGearsCount);
        setBatteryCapacity(batteryCapacity);
    }
}
