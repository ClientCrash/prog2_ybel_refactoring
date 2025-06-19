package refactoring;

/**
 * Base class for all bike types.
 * Represents a bike with basic properties like name, price, battery capacity, speed and gears.
 */
public class Bike {

    private String productName;
    private double price;
    private Integer batteryCapacity;
    private int maxSpeed;
    private int rearGearsCount;
    private int frontGearsCount;

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
     * Gets the maximum speed of this bike.
     * @return the maximum speed in km/h
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Sets the maximum speed of this bike.
     * @param maxSpeed the maximum speed in km/h
     */
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    /**
     * Gets the number of rear gears.
     * @return the number of rear gears
     */
    public int getRearGearsCount() {
        return rearGearsCount;
    }

    /**
     * Sets the number of rear gears.
     * @param rearGearsCount the number of rear gears
     */
    public void setRearGearsCount(int rearGearsCount) {
        this.rearGearsCount = rearGearsCount;
    }

    /**
     * Gets the number of front gears.
     * @return the number of front gears
     */
    public int getFrontGearsCount() {
        return frontGearsCount;
    }

    /**
     * Sets the number of front gears.
     * @param frontGearsCount the number of front gears
     */
    public void setFrontGearsCount(int frontGearsCount) {
        this.frontGearsCount = frontGearsCount;
    }

    /**
     * Gets the total number of gears for this bike.
     * Default implementation multiplies rear and front gears.
     * @return the number of gears
     */
    public int getGearsCount() {
        return rearGearsCount * frontGearsCount;
    }

    /**
     * Calculates the total price for a given purchase amount.
     * Includes bike-specific discounts and high-value discount.
     * @param purchaseAmount the number of bikes to purchase
     * @return the total price after all discounts
     */
    public double calculateTotalPrice(int purchaseAmount) {
        double basePrice = calculateBasePrice(purchaseAmount);
        return applyHighValueDiscount(basePrice);
    }

    /**
     * Calculates the base price before high-value discount.
     * Default implementation: price * amount (no special discounts).
     * Override in subclasses for bike-specific pricing.
     * @param purchaseAmount the number of bikes to purchase
     * @return the base price
     */
    protected double calculateBasePrice(int purchaseAmount) {
        return price * purchaseAmount;
    }

    /**
     * Applies 20% discount for purchases >= 1000 euros.
     * @param price the base price
     * @return price after high-value discount
     */
    private double applyHighValueDiscount(double price) {
        if (price >= 1000.0) {
            return price * 0.8;
        }
        return price;
    }
}
