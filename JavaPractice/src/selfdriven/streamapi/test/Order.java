package test;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private int orderId;
    private int customerId;
    private String city;
    private LocalDate orderDate;

    public Order() {
    }

    public Order(int orderId, int customerId, String city, LocalDate orderDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.city = city;
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    List<Order> createOrderList() {
        return List.of(
                new Order(1, 101, "Pune", LocalDate.of(2024, 1, 10)),
                new Order(2, 102, "Mumbai", LocalDate.of(2024, 1, 12)),
                new Order(3, 103, "Delhi", LocalDate.of(2024, 1, 15)),
                new Order(4, 101, "Pune", LocalDate.of(2024, 2, 1)),
                new Order(5, 104, "Bangalore", LocalDate.of(2024, 2, 5)),
                new Order(6, 105, "Chennai", LocalDate.of(2024, 2, 10)),
                new Order(7, 102, "Mumbai", LocalDate.of(2024, 3, 3)),
                new Order(8, 106, "Hyderabad", LocalDate.of(2024, 3, 7)),
                new Order(9, 103, "Delhi", LocalDate.of(2024, 3, 15)),
                new Order(10, 107, "Kolkata", LocalDate.of(2024, 3, 20))
        );
    }
}
