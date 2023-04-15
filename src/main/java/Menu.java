import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    static void run() {
        while (true) {

            // Showing menu
            System.out.println("""
                    Choose your action:\s
                    1) Add Income
                    2) Add Purchase
                    3) Show the list of purchases
                    4) Balance
                    5) Save
                    6) Load
                    7) Analyze (Sort)
                    0) Exit""");

            try {
                int userChoice = scanner.nextInt();

                switch (userChoice) {
                    case 1 -> Balance.addIncome();
                    case 2 -> Expenses.addPurchaseToExpenses();
                    case 3 -> Expenses.showCategories();
                    case 4 -> Balance.showBalance();
                    case 5 -> Data.saveData();
                    case 6 -> Data.loadData();
                    case 7 -> Analyzer.analyze();
                    case 0 -> {
                        System.out.println("\nBye!");
                        return;
                    }
                    default -> System.out.println("\nWrong input");
                }

            }catch (Exception exception){
                System.out.println("Wrong input");
                break;
            }
        }
    }
}
