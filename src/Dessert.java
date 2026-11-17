public class Dessert extends Product {
    private int calories;
    private boolean isGlutenFree;

    public Dessert(String name, double price, int calories, boolean isGlutenFree) {
        super(name, price);
        this.calories = calories;
        this.isGlutenFree = isGlutenFree;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public boolean getIsGlutenFree() {
        return isGlutenFree;
    }

    public void setIsGlutenFree(boolean isGlutenFree) {
        this.isGlutenFree = isGlutenFree;
    }

    public void addWhippedCream() {
        this.calories += 120;
        System.out.println("Dodano bita smietane do deseru " + getName() + ". Kalorie: " + this.calories);
    }

    @Override
    public String getCategoryDescription() {
        return "Kategoria: Deser cukierniczy (kalorie: " + calories + " kcal)";
    }

    @Override
    public String toString() {
        return "Dessert{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", calories=" + calories +
                ", isGlutenFree=" + isGlutenFree +
                '}';
    }
}