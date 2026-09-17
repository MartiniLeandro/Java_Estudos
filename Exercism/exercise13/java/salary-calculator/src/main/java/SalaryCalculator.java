public class SalaryCalculator {

    public double salaryMultiplier(int daysSkipped) {
        boolean salaryPenalty = daysSkipped >= 5;
        return salaryPenalty ? 0.85 : 1.0;
    }

    public int bonusMultiplier(int productsSold) {
        boolean bonusAchieved = productsSold >= 20;
        return bonusAchieved ? 13 : 10;
    }

    public double bonusForProductsSold(int productsSold) {
        int bonusMultiplier = bonusMultiplier(productsSold);
        return productsSold * bonusMultiplier;
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        double baseSalary = 1000.00;
        double salaryMultiplier = salaryMultiplier(daysSkipped);
        double bonusForProductsSold = bonusForProductsSold(productsSold);
        double finalSalary = baseSalary * salaryMultiplier + bonusForProductsSold;
        return finalSalary <= 2000.00 ? finalSalary : 2000.00;
    }

}
