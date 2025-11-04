import java.util.*;

public class LaborMarket {
    private BoroughEconomy boroughEconomy;
    private List<Worker> availableWorkers;
    private double marketTargetWage;   // theoretical mean: 14.5 * factor
    private double marketAverageWage;  // actual avg of generated desiredWage

    private static final String[] ROLES = {"Cook", "Waiter", "Janitor", "Cook", "Waiter"};
    private static final Random rand = new Random();

    public LaborMarket(BoroughEconomy boroughEconomy) {
        this.boroughEconomy = boroughEconomy;
        this.availableWorkers = new ArrayList<>();
        this.marketTargetWage = 0.0;
        this.marketAverageWage = 0.0;
        generateWorkers();
        calculateAverageWage();
    }

    private void generateWorkers() {
        availableWorkers.clear();
        double factor = boroughEconomy.getEconomicFactor();

        // Number of available workers = 10 * factor (at least 1)
        int numWorkers = Math.max(1, (int) Math.round(10 * factor));

        // Theoretical target wage for the market
        marketTargetWage = 14.5 * factor;

        for (int i = 0; i < numWorkers; i++) {
            String name = boroughEconomy.getName() + "_Worker" + (i + 1);
            String role = ROLES[rand.nextInt(ROLES.length)];

            // desired wage: normal dist centered on marketTargetWage, stddev ~2.0
            double desiredWage = marketTargetWage + rand.nextGaussian() * 2.0;
            desiredWage = Math.max(8.0, desiredWage); // minimum wage floor

            // efficiency: normal dist centered at 50, stddev ~15, clamp 0-100
            double efficiency = 50 + rand.nextGaussian() * 15.0;
            efficiency = Math.max(0.0, Math.min(100.0, efficiency));

            // experience: normal dist influenced by factor (mean ~5*factor, stddev ~2)
            double experience = rand.nextGaussian() * 2.0 + (5.0 * factor);
            experience = Math.max(0.0, experience);

            int morale = 60 + rand.nextInt(41); // 60..100

            // Use your existing Worker constructor (name, experience, efficiency, morale)
            Worker w = new Worker(name, experience, efficiency, morale);

            // Set role and desiredWage — requires your Worker to have these setters
            w.setRole(role);
            w.setDesiredWage(desiredWage);

            availableWorkers.add(w);
        }
    }

    // Sets marketAverageWage based on generated workers.
    private void calculateAverageWage() {
        if (availableWorkers.isEmpty()) {
            marketAverageWage = marketTargetWage;
            return;
        }
        double sum = 0.0;
        for (Worker w : availableWorkers) {
            sum += w.getDesiredWage();
        }
        marketAverageWage = sum / availableWorkers.size();
    }

    // Public getter for the theoretical target wage (14.5 * factor)
    public double getMarketTargetWage() {
        return marketTargetWage;
    }

    // Public getter for the actual average desired wage from workers
    public double getMarketAverageWage() {
        return marketAverageWage;
    }

    public Worker hireWorker() {
        if (availableWorkers.isEmpty()) return null;
        Worker hired = availableWorkers.remove(0);
        // recompute average after hire
        calculateAverageWage();
        return hired;
    }

    public int getAvailableWorkerCount() {
        return availableWorkers.size();
    }

    public void refreshMarket() {
        generateWorkers();
        calculateAverageWage();
    }

    public List<Worker> getAvailableWorkers() {
        return Collections.unmodifiableList(availableWorkers);
    }
}
