package test;

import java.util.List;

public class Product {

    private int productId;
    private String category;
    private double price;
    private int quantity;

    public Product() {
    }

    public Product(int productId, String category, double price, int quantity) {
        this.productId = productId;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Product> createProducts() {
        return List.of(
                new Product(1, "Electronics", 49999.00, 5),
                new Product(2, "Electronics", 29999.00, 10),
                new Product(3, "Clothing", 1999.00, 50),
                new Product(4, "Clothing", 1499.00, 40),
                new Product(5, "Home", 7999.00, 15),
                new Product(6, "Home", 12999.00, 8),
                new Product(7, "Books", 599.00, 100),
                new Product(8, "Books", 899.00, 60),
                new Product(9, "Sports", 2499.00, 25),
                new Product(10, "Sports", 3999.00, 12)
        );
    }
}
