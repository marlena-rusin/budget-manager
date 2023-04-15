import java.util.Scanner;

public class Balance {

    // Default value
    static double accountBalance = 0;

    static Scanner scanner = new Scanner(System.in);

    // Adding income
    static void addIncome() {
        System.out.println("\nEnter the income: ");
        int income = scanner.nextInt();
        accountBalance += income;
        System.out.println("Income was added!\n");
    }

    //Showing balance
    static void showBalance() {
        System.out.println("\nBalance: $" + String.format("%.2f", accountBalance) + "\n");
    }


}
