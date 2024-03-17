import java.time.LocalDate;

public class AnalyticsManager {

    public static void main(String[] args) {
        // Example usage of analytics methods
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 12, 31);

        double totalIncome = DatabaseManager.getTotalIncomeForPeriod(startDate, endDate);
        System.out.println("Total income for the period: $" + totalIncome);

        String mostPopularService = DatabaseManager.getMostPopularServiceForPeriod(startDate, endDate);
        System.out.println("Most popular service for the period: " + mostPopularService);

        int topClient = DatabaseManager.getTopClientForPeriod(startDate, endDate);
        System.out.println("Top client for the period (Client ID): " + topClient);

        int totalClients = DatabaseManager.getTotalNumberOfClients();
        System.out.println("Total number of clients: " + totalClients);

        int totalServices = DatabaseManager.getTotalNumberOfServices();
        System.out.println("Total number of services: " + totalServices);

        double averageIncomePerClient = totalIncome / totalClients;
        System.out.println("Average income per client: $" + averageIncomePerClient);
    }

    // Additional analytics methods can be added here
}
