public class DiscountCalculator {
    /**
     * Calculate the total cost after applying a discount.
     *
     * @param originalPrice      The original price of the item.
     * @param discountPercentage The discount percentage (0 to 100).
     * @return The total cost after discount.
     * @throws IllegalArgumentException If the input types are invalid or the discount percentage is out of range.
     */
    public double calculateDiscountedPrice(double originalPrice, double discountPercentage) {
        if (Double.isNaN(originalPrice) || Double.isNaN(discountPercentage)) {
            throw new IllegalArgumentException("Invalid input type");
        }

        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount percentage should be between 0 and 100");
        }

        double discount = originalPrice * (discountPercentage / 100);
        return originalPrice - discount;
    }
}
