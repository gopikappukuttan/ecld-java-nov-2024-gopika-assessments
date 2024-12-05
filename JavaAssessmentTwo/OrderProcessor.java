import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

abstract class Order {
    protected String orderId;
    protected String customerName;
    protected LocalDateTime orderDate;
    protected List<OrderItem> items;

    public Order(String orderId, String customerName, LocalDateTime orderDate, List<OrderItem> items) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.items = items;
    }

    abstract double calculateTotal();

    abstract double calculateDiscount();

    public String getCustomerName() {
        return customerName;
    }
}

class OrderItem {
    String productId;
    int quantity;
    double pricePerUnit;

    public OrderItem(String productId, int quantity, double pricePerUnit) {
        this.productId = productId;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }
}

class RegularOrder extends Order {
    double minimumForDiscount = 100.0;
    double discountPercent = 10.0;

    public RegularOrder(String orderId, String customerName, LocalDateTime orderDate, List<OrderItem> items) {
        super(orderId, customerName, orderDate, items);
    }

    @Override
    double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.quantity * item.pricePerUnit;
        }
        return total;
    }

    @Override
    double calculateDiscount() {
        double total = calculateTotal();
        if (total >= minimumForDiscount) {
            return total * (discountPercent / 100);
        }
        return 0;
    }
}

class PriorityOrder extends Order {
    boolean expressShipping;
    double additionalFee;

    public PriorityOrder(String orderId, String customerName, LocalDateTime orderDate, List<OrderItem> items, boolean expressShipping, double additionalFee) {
        super(orderId, customerName, orderDate, items);
        this.expressShipping = expressShipping;
        this.additionalFee = additionalFee;
    }

    @Override
    double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.quantity * item.pricePerUnit;
        }
        if (expressShipping) {
            total += additionalFee;
        }
        return total;
    }

    @Override
    double calculateDiscount() {
        return 0;
    }
}

public class OrderProcessor {
    private List<Order> orders = new LinkedList<>();

    public void processOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrdersByCustomer(String customerName) {
        List<Order> orderOfCustomers = new LinkedList<>();
        for (Order order : orders) {
            if (order.getCustomerName().equalsIgnoreCase(customerName)) {
                orderOfCustomers.add(order);
            }
        }
        return orderOfCustomers;
    }

    public double getTotalRevenue() {
        double totalRevenue = 0;
        for (Order order : orders) {
            totalRevenue += order.calculateTotal();
        }
        return totalRevenue;
    }

    public double getAverageOrderValue() {
        return getTotalRevenue() / orders.size();
    }

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
try {
    // Create order
    OrderItem itemOne = new OrderItem("1", 2, 80.0);
    OrderItem itemTwo = new OrderItem("2", 5, 50.0);

    // Create regular orders
    List<OrderItem> items = new ArrayList<>();
    items.add(itemOne);
    items.add(itemTwo);
    RegularOrder regularOrder = new RegularOrder("1", "Gopika P A", LocalDateTime.now(), items);
    //create priority orders
    PriorityOrder priorityOrder = new PriorityOrder("2", "Sruthy", LocalDateTime.now(), items, true, 25.0);

    // Process orders
    processor.processOrder(regularOrder);
    processor.processOrder(priorityOrder);

    // results
    System.out.println("Total Revenue: " + processor.getTotalRevenue());
    System.out.println("Average Order Value: " + processor.getAverageOrderValue());
} catch (IllegalArgumentException e) {
    System.out.println(e.getMessage());
}
    }


}
