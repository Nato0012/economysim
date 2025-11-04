public class Worker {
    private String name;
    private double experience;
    private double efficiency;
    private int morale;
    private String role;
    private double desiredWage;

    // Default constructor
    public Worker() {
        this("None", 0.0, 50.0, 100);
    }

    // Main constructor
    public Worker(String name, double experience, double efficiency, int morale) {
        this.name = name;
        this.experience = experience;
        this.efficiency = efficiency;
        this.morale = morale;
        this.role = "Unassigned";
        this.desiredWage = 14.5;
    }

    // Getters
    public String getName() { return name; }
    public double getExperience() { return experience; }
    public double getEfficiency() { return efficiency; }
    public int getMorale() { return morale; }
    public String getRole() { return role; }
    public double getDesiredWage() { return desiredWage; }

    // Setters
    public void setExperience(double experience) { this.experience = experience; }
    public void setEfficiency(double efficiency) { this.efficiency = efficiency; }
    public void setMorale(int morale) { this.morale = morale; }
    public void setRole(String role) { this.role = role; }
    public void setDesiredWage(double desiredWage) { this.desiredWage = desiredWage; }

    public String toString() {
        return String.format("%s (%s): $%.2f/hr | Exp: %.1f yrs | Eff: %.1f | Morale: %d",
                name, role, desiredWage, experience, efficiency, morale);
    }
}

  
