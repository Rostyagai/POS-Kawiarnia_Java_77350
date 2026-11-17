public class Beverage extends Product {
    private Size size;
    private boolean isHot;

    public Beverage(String name, double price, Size size, boolean isHot) {
        super(name, price);
        this.size = size;
        this.isHot = isHot;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public boolean getIsHot() {
        return isHot;
    }

    public void setIsHot(boolean isHot) {
        this.isHot = isHot;
    }

    public void heatUp() {
        this.isHot = true;
        System.out.println("Napoj " + getName() + " zostal podgrzany do wysokiej temperatury.");
    }

    @Override
    public String getCategoryDescription() {
        return "Kategoria: Napoj (rozmiar: " + size + ")";
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", size=" + size +
                ", isHot=" + isHot +
                '}';
    }
}