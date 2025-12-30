import java.util.*;

class Order {
    String customerName;
    List<String> items;

    public Order(String customerName, List<String> items) {
        this.customerName = customerName;
        this.items = items;
    }
}

public class ComplexExample {

    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("Alice", Arrays.asList("Laptop", "Mouse", "Keyboard")));
        orders.add(new Order("Bob", Arrays.asList("Phone")));
        orders.add(new Order("Charlie", Arrays.asList("Book", "Pen")));
        orders.add(new Order("David", Arrays.asList("Tablet", "Charger", "Headphones", "Case")));
        orders.add(new Order("Eve", Arrays.asList("Camera")));
        orders.add(new Order("Frank", Arrays.asList("Shoes", "Shirt", "Watch")));

        long startTime = System.currentTimeMillis(); // start timer

        processOrders(orders);

        long endTime = System.currentTimeMillis();   // end timer
        System.out.println("Total time taken by processOrders: " + (endTime - startTime) + " ms");
    }

    // 👍 Optimized method
    public static void processOrders(List<Order> orders) {
        System.out.println("=== Start Processing Orders ===");

        Set<String> processedNames = new HashSet<>();

        for (Order order : orders) {
            String name = order.customerName;

            // Print order details
            System.out.println("Order for " + name + ": " + order.items);

            // Print items with index info
            for (int j = 0; j < order.items.size(); j++) {
                String item = order.items.get(j);
                System.out.println("  " + (j % 2 == 0 ? "Even" : "Odd") + " index item: " + item);
            }

            // VIP and name-ending checks
            if (isVipCustomer(name)) {
                System.out.println(name + " is a VIP customer!");
            } else if (name.endsWith("e")) {
                System.out.println(name + " ends with 'e'");
            }

            // Only print duplicate check once per customer
            if (processedNames.add(name)) {
                System.out.println("Duplicate check: " + name + " => OK");
            }
        }

        System.out.println("=== End Processing Orders ===");
    }

    private static boolean isVipCustomer(String name) {
        if (name == null || name.isEmpty()) return false;
        char first = Character.toUpperCase(name.charAt(0));
        return first == 'A' || first == 'E' || first == 'I' || first == 'O' || first == 'U';
    }
}
