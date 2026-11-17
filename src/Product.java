import java.util.Objects;

public abstract class Product implements Comparable<Product>, Discountable {
    private String name;
    private double price;
    private static int totalProductsCreated = 0;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        totalProductsCreated++;
    }

    public abstract String getCategoryDescription();

    public static int getTotalProductsCreated() {
        return totalProductsCreated;
    }

    public static void setTotalProductsCreated(int count) {
        if (count >= 0) {
            totalProductsCreated = count;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        if (newPrice > 0) {
            this.price = newPrice;
        } else {
            System.out.println("Cena musi byc wieksza od zera.");
        }
    }

    public double getPriceBrutto() {
        return Math.round(price * 1.23 * 100.0) / 100.0;
    }

    @Override
    public void applyDiscount(double percent) {
        if (percent > 0 && percent <= maxDiscount) {
            double discountAmount = this.price * (percent / 100.0);
            this.price = Math.round((this.price - discountAmount) * 100.0) / 100.0;
        } else {
            System.out.println("Nieprawidlowy procent rabatu. Maksymalny rabat to: " + maxDiscount + "%");
        }
    }

    @Override
    public int compareTo(Product otherProduct) {
        return this.name.compareTo(otherProduct.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", brutto=" + getPriceBrutto() +
                '}';
    }
}