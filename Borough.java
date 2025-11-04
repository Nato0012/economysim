public class Borough {
    private String name;
    private double rent;
    private double economicFactor;

    public Borough() {
        this("None", 1000.0, 1.0);
    }

    public Borough(String name, double rent, double economicFactor) {
        this.name = name;
        this.rent = rent;
        this.economicFactor = economicFactor;
    }

    // === Getters ===
    public String getName() {
        return name;
    }

    public double getRent() {
        return rent;
    }

    public double getEconomicFactor() {
        return economicFactor;
    }

    // === Optional: toString for debugging ===
    @Override
    public String toString() {
        return String.format("%s | Rent: $%.0f | EconFactor: %.2f", name, rent, economicFactor);
    }
}

