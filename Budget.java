import java.util.Scanner;

public class Budget {
    private double budget;

    public Budget() {
        this.budget = 0.0;
    }

    public void setBudget(double amount) {
        if (amount < 0) {
            System.out.println("Please enter a positive amount.");
        } else {
            this.budget = amount;
            System.out.printf("Budget set to $%.2f%n", amount);
        }
    }

    public double getBudget() {
        return this.budget;
    }

    public void updateBudget(double amount) {
        if (amount < 0) {
            System.out.println("Please enter a positive amount.");
        } else {
            this.budget += amount;
            System.out.printf("Budget updated to $%.2f%n", this.budget);
        }
    }

    public static void main(String[] args) {
        Budget myBudget = new Budget();
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter your initial budget: ");
        double initialBudget = scanner.nextDouble();
        myBudget.setBudget(initialBudget);


        System.out.print("Enter the amount to update the budget: ");
        double updateAmount = scanner.nextDouble();
        myBudget.updateBudget(updateAmount);

        System.out.printf("Current Budget: $%.2f%n", myBudget.getBudget());
    }
}
