public class Barista extends Employee {
    private int coffeesPrepared;

    public Barista(String firstName, String lastName, int employeeId, int coffeesPrepared) {
        super(firstName, lastName, employeeId);
        this.coffeesPrepared = coffeesPrepared;
    }

    public int getCoffeesPrepared() {
        return coffeesPrepared;
    }

    public void setCoffeesPrepared(int coffeesPrepared) {
        this.coffeesPrepared = coffeesPrepared;
    }

    public void brewSpecialtyCoffee() {
        this.coffeesPrepared++;
        System.out.println("Barista " + getFirstName() + " zaparzyl kawe specjalna. Liczba kaw: " + coffeesPrepared);
    }

    @Override
    public double calculateBonus() {
        return coffeesPrepared * 2.5;
    }

    @Override
    public String toString() {
        return "Barista{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", employeeId=" + getEmployeeId() +
                ", coffeesPrepared=" + coffeesPrepared +
                '}';
    }
}