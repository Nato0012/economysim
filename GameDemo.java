import java.util.*;

public class GameDemo {
    public static void main(String[] args) {
        // Set up the boroughs (rent, economicFactor)
        List<Borough> boroughs = List.of(
                new Borough("Manhattan", 10000, 1.4),
                new Borough("Brooklyn", 7500, 1.2),
                new Borough("Queens", 6000, 1.0),
                new Borough("Bronx", 4500, 0.8),
                new Borough("Staten Island", 4000, 0.7)
        );

        // Create a LaborMarket for each borough
        for (Borough borough : boroughs) {
            LaborMarket market = new LaborMarket(borough);

            System.out.println("==== " + borough.getName() + " Labor Market ====");
            System.out.printf("Rent: $%,.0f | Econ Factor: %.1f%n",
                    borough.getRent(), borough.getEconomicFactor());
            System.out.printf("Target Wage: $%.2f | Actual Avg Wage: $%.2f%n",
                    market.getMarketTargetWage(), market.getMarketAverageWage());
            System.out.println("Workers Available: " + market.getAvailableWorkerCount());

            // Print 3 sample workers
            List<Worker> sample = market.getAvailableWorkers();
            for (int i = 0; i < Math.min(3, sample.size()); i++) {
                System.out.println("  - " + sample.get(i));
            }
            System.out.println();
        }
    }
}
