import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private double savings;
    private Borough borough;
    private double rent;
    private List<Worker> staff;

    public Company(String name, Borough borough, double initialSavings) {
        this.name = name;
        this.borough = borough;
        this.savings = initialSavings;
        this.rent = borough.getRent();  // rent based on location
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
            System.out.println("Paid rent: $" + rent);
        } else {
            System.out.println("Not enough funds to pay rent!");
        }
    }

    public void payWages() {
        double totalWages = 0;
        for (Worker w : staff) {
            totalWages += w.getDesiredWage() * 160; // assuming full month (40h * 4w)
        }

        if (savings >= totalWages) {
            savings -= totalWages;
            System.out.printf("Paid wages: $%.2f%n", totalWages);
        } else {
            System.out.println("Not enough funds to pay all wages!");
        }
    }

    // === Getters ===
    public String getName() { return name; }
    public double getSavings() { return savings; }
    public Borough getBorough() { return borough; }
    public double getRent() { return rent; }
    public List<Worker> getStaff() { return staff; }

    // === For debugging ===
    @Override
    public String toString() {
        return String.format("%s | Borough: %s | Savings: $%,.2f | Staff: %d",
                name, borough.getName(), savings, staff.size());
    }
}
