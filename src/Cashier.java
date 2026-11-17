public class Cashier extends Employee {
    private int ordersHandled;

    public Cashier(String firstName, String lastName, int employeeId, int ordersHandled) {
        super(firstName, lastName, employeeId);
        this.ordersHandled = ordersHandled;
    }

    public int getOrdersHandled() {
        return ordersHandled;
    }

    public void setOrdersHandled(int ordersHandled) {
        this.ordersHandled = ordersHandled;
    }

    public void openCashRegister() {
        this.ordersHandled++;
        System.out.println("Kasjer " + getFirstName() + " otworzyl szuflade kasy fiskalnej.");
    }

    @Override
    public double calculateBonus() {
        return ordersHandled * 1.5;
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", employeeId=" + getEmployeeId() +
                ", ordersHandled=" + ordersHandled +
                '}';
    }
}