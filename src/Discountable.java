public interface Discountable {
    static double maxDiscount = 50.0;

    void applyDiscount(double percent);

    default void printDiscountPolicy() {
        System.out.println("Maksymalny mozliwy rabat w kawiarni wynosi: " + maxDiscount + "%");
    }
}