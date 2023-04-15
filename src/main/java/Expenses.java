import java.util.*;

public class Expenses {

    static Scanner scanner = new Scanner(System.in);

    static void showCategories(){
        while (true) {

            // Showing menu
            System.out.println("""

                    Choose the type of purchase
                    1) Food
                    2) Clothes
                    3) Entertainment
                    4) Other
                    5) All
                    6) Back""");

            int purchaseID = Integer.parseInt(scanner.nextLine());

            switch (purchaseID) {
                case 1 -> {
                    System.out.println("\nFood: ");
                    showExpenses(Purchase.getCategory(purchaseID));
                }
                case 2 -> {
                    System.out.println("\nClothes: ");
                    showExpenses(Purchase.getCategory(purchaseID));
                }
                case 3 -> {
                    System.out.println("\nEntertainment: ");
                    showExpenses(Purchase.getCategory(purchaseID));
                }
                case 4 -> {
                    System.out.println("\nOther: ");
                    showExpenses(Purchase.getCategory(purchaseID));
                }
                case 5 -> {
                    System.out.println("\nAll: ");
                    updateAll();
                    showExpenses(Purchase.all);
                }
                case 6 -> {
                    return;
                }
                default -> System.out.println("\nWrong input");
                }
            }
        }

    // Updating content of list for all categories
    static void updateAll(){
        Purchase.all.putAll(Purchase.getCategory(1));
        Purchase.all.putAll(Purchase.getCategory(2));
        Purchase.all.putAll(Purchase.getCategory(3));
        Purchase.all.putAll(Purchase.getCategory(4));
    }

    // Adding purchase
    static void addPurchaseToExpenses(){
        while (true){
            System.out.println("""

                    Choose the type of purchase:\s
                    1) Food
                    2) Clothes
                    3) Entertainment
                    4) Other
                    5) Back""");

            int purchaseID = Integer.parseInt(scanner.nextLine());

            if (purchaseID == 5) {
                System.out.println();
                return;
            }

            Purchase.addPurchase(purchaseID);
        }
    }

    // Showing the content of the list of purchases
    static void showExpenses(Map<String, Double> listOfExpenses) {
        if (listOfExpenses.isEmpty()) {
            System.out.println("The purchase list is empty");
        } else {
            listOfExpenses.forEach((key, value) -> System.out.println(key + " $" + String.format("%.2f", value)));

            showTotal(listOfExpenses);
        }
    }

    // Showing total sum of prices of the purchases from the list
    static void showTotal(Map<String, Double> listOfExpenses) {
        double total = listOfExpenses.values().stream().mapToDouble(d -> d).sum();
        System.out.println("Total sum: $" + String.format("%.2f", total));
    }

    // Counting total for specific category list
    static double countTotal(Map<String, Double> listOfExpenses){
        return listOfExpenses.values().stream().mapToDouble(d -> d).sum();
    }
}
