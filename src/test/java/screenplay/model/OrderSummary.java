package screenplay.model;

import java.util.ArrayList;
import java.util.List;

public class OrderSummary {
    private final List<Product> products;
    private double subTotal;
    private double shippingCost;
    private double total;

    public OrderSummary() {
        this.products = new ArrayList<>();
        this.subTotal = 0.0;
        this.shippingCost = 0.0;
        this.total = 0.0;
    }

    public void addProduct(Product product) {
        products.add(product);
        calculateTotals();
    }

    public void removeProduct(Product product) {
        products.remove(product);
        calculateTotals();
    }

    private void calculateTotals() {
        subTotal = products.stream()
                .mapToDouble(Product::getTotal)
                .sum();
        // Flat shipping rate en OpenCart
        shippingCost = products.isEmpty() ? 0.0 : 5.00;
        total = subTotal + shippingCost;
    }

    public int getItemCount() {
        return products.size();
    }

    public boolean containsProduct(String productName) {
        return products.stream()
                .anyMatch(p -> p.getName().equalsIgnoreCase(productName));
    }

    // Getters
    public List<Product> getProducts() { return new ArrayList<>(products); }
    public double getSubTotal() { return subTotal; }
    public double getShippingCost() { return shippingCost; }
    public double getTotal() { return total; }

    @Override
    public String toString() {
        return String.format("OrderSummary{items=%d, subTotal=%.2f, shipping=%.2f, total=%.2f}",
                products.size(), subTotal, shippingCost, total);
    }
}
