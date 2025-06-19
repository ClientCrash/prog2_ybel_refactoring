package refactoring;

/**
 * Base class for all bike types.
 * Represents a bike with basic properties like name, price and battery capacity.
 */
public class Bike {

    private String productName;
    private double price;
    private Integer batteryCapacity;

    /**
     * Gets the product name of this bike.
     * @return the product name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the product name of this bike.
     * @param productName the product name to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Gets the price of this bike.
     * @return the price in euros
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of this bike.
     * @param price the price in euros
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the battery capacity of this bike.
     * @return the battery capacity in mAh, or null if no battery
     */
    public Integer getBatteryCapacity() {
        return batteryCapacity;
    }

    /**
     * Sets the battery capacity of this bike.
     * @param batteryCapacity the battery capacity in mAh
     */
    public void setBatteryCapacity(Integer batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    /**
     * Gets the total number of gears for this bike.
     * @return the number of gears
     * @throws UnsupportedOperationException if not implemented by subclass
     */
    public int getGearsCount() {
        throw new UnsupportedOperationException("Not Implemented");
    }
}
