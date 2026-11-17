import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private Customer customer;
    private List<Product> products;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) throws InvalidOrderException {
        if (product == null) {
            throw new InvalidOrderException("Nie mozna dodac pustego produktu (null) do zamowienia!", 101);
        }
        if (product.getPrice() <= 0) {
            throw new InvalidOrderException("Produkt ma nieprawidlowa cene!", 102);
        }
        products.add(product);
        customer.addLoyaltyPoints(5);
    }

    public double calculateTotal() {
        double sum = 0.0;
        for (Product p : products) {
            sum += p.getPrice();
        }
        return Math.round(sum * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customer=" + customer.getName() +
                ", itemsCount=" + products.size() +
                ", total=" + calculateTotal() + " PLN" +
                '}';
    }
}