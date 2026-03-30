package screenplay.model;

public class Product {
    private final String id;
    private final String name;
    private final double price;
    private int quantity;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = 1;
    }

    public Product(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Productos predefinidos para OpenCart
    public static Product iPhone() {
        return new Product("40", "iPhone", 123.20);
    }

    public static Product macBook() {
        return new Product("43", "MacBook", 602.00);
    }

    public static Product appleCinema() {
        return new Product("42", "Apple Cinema 30\"", 122.00);
    }

    public static Product canonEos() {
        return new Product("30", "Canon EOS 5D", 98.00);
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return String.format("Product{id='%s', name='%s', price=%.2f, quantity=%d}", 
                           id, name, price, quantity);
    }
}
