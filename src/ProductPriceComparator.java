import java.util.Comparator;

public class ProductPriceComparator implements Comparator<Product> {
    private boolean ascending;

    public ProductPriceComparator(boolean ascending) {
        this.ascending = ascending;
    }

    public boolean getAscending() {
        return ascending;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(Product p1, Product p2) {
        if (ascending) {
            return Double.valueOf(p1.getPrice()).compareTo(p2.getPrice());
        } else {
            return Double.valueOf(p2.getPrice()).compareTo(p1.getPrice());
        }
    }
}