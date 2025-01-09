import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Order {
    private String customerId;
    private double amount;
    private List<String> items;
    private LocalDate orderDate;

    public Order(String customerId, double amount, List<String> items, LocalDate orderDate) {
        this.customerId = customerId;
        this.amount = amount;
        this.items = items;
        this.orderDate = orderDate;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}

public class CustomerOrderAnalysis {
    public Map<String, Double> analyzeOrders(List<Order> orders) {
        return orders.stream()
                .filter(order -> order.getAmount() > 100 && order.getOrderDate().getYear() == 2024)
                .collect(Collectors.groupingBy(
                        Order::getCustomerId,
                        Collectors.summingDouble(Order::getAmount)
                ));
    }

    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("C1", 150.0, Arrays.asList("Item1", "Item2"), LocalDate.of(2024, 1,
                        15)),
                new Order("C1", 50.0, Arrays.asList("Item3"), LocalDate.of(2024, 1, 20)),
                new Order("C2", 200.0, Arrays.asList("Item1", "Item4"), LocalDate.of(2024, 1,
                        15)),
                new Order("C1", 120.0, Arrays.asList("Item2", "Item5"), LocalDate.of(2023, 12,
                        15))
        );

        CustomerOrderAnalysis analysis = new CustomerOrderAnalysis();
        Map<String, Double> result = analysis.analyzeOrders(orders);

        // Print the result
        System.out.println("Orders above $100 in 2024");
        result.forEach((customerId, totalAmount) ->
                System.out.println("Customer ID: " + customerId + ", Total Amount: " + totalAmount));

    }
}

