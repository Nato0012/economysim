import java.util.*;

public class Company {
    private String name;
    private double savings;
    private Borough borough;
    private double rent;
    private List<Worker> staff;

    // Staffing requirements
    private static final int REQUIRED_COOKS = 2;
    private static final int REQUIRED_WAITERS = 5;
    private static final int REQUIRED_JANITORS = 1;

    public Company(String name, Borough borough, double initialSavings) {
        this.name = name;
        this.borough = borough;
        this.savings = initialSavings;
        this.rent = borough.getRent();
        this.staff = new ArrayList<>();
    }

    // === Core Methods ===
    public void hireWorker(Worker w) {
        staff.add(w);
        System.out.println(w.getName() + " hired as " + w.getRole() + ".");
    }

    public void fireWorker(Worker w) {
        if (staff.remove(w)) {
            System.out.println(w.getName() + " has been fired.");
        } else {
            System.out.println("Worker not found.");
        }
    }

    public void payRent() {
        if (savings >= rent) {
            savings -= rent;
            System.out.printf("Paid rent: $%,.2f%n", rent);
        } else {
            System.out.println("Not enough funds to pay rent!");
        }
    }

    public void payWages() {
        double totalWages = staff.stream()
                .mapToDouble(w -> w.getDesiredWage() * 160)
                .sum();

        if (savings >= totalWages) {
            savings -= totalWages;
            System.out.printf("Paid wages: $%,.2f%n", totalWages);
        } else {
            System.out.println("Not enough funds to pay all wages!");
        }
    }

    // === Staffing Validation ===
    public boolean hasRequiredStaff() {
        long cooks = staff.stream().filter(w -> "Cook".equalsIgnoreCase(w.getRole())).count();
        long waiters = staff.stream().filter(w -> "Waiter".equalsIgnoreCase(w.getRole())).count();
        long janitors = staff.stream().filter(w -> "Janitor".equalsIgnoreCase(w.getRole())).count();

        return cooks >= REQUIRED_COOKS && waiters >= REQUIRED_WAITERS && janitors >= REQUIRED_JANITORS;
    }

    public void showStaffingStatus() {
        long cooks = staff.stream().filter(w -> "Cook".equalsIgnoreCase(w.getRole())).count();
        long waiters = staff.stream().filter(w -> "Waiter".equalsIgnoreCase(w.getRole())).count();
        long janitors = staff.stream().filter(w -> "Janitor".equalsIgnoreCase(w.getRole())).count();

        System.out.printf("Cooks: %d/%d | Waiters: %d/%d | Janitors: %d/%d%n",
                cooks, REQUIRED_COOKS, waiters, REQUIRED_WAITERS, janitors, REQUIRED_JANITORS);
        System.out.println(hasRequiredStaff() ? "✅ Fully staffed!" : "⚠️ Missing staff!");
    }

    // === Getters & Setters ===
    public String getName() { return name; }
    public double getSavings() { return savings; }
    public void setSavings(double savings) { this.savings = savings; }
    public Borough getBorough() { return borough; }
    public double getRent() { return rent; }
    public List<Worker> getStaff() { return staff; }

    @Override
    public String toString() {
        return String.format("%s | Borough: %s | Savings: $%,.2f | Staff: %d",
                name, borough.getName(), savings, staff.size());
    }
}
