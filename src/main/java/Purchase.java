import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Purchase {

    static Scanner scanner = new Scanner(System.in);

    static Map<String, Double> food = new HashMap<>();
    static Map<String, Double> clothes = new HashMap<>();
    static Map<String, Double> entertainment = new HashMap<>();
    static Map<String, Double> other = new HashMap<>();
    static Map<String, Double> all = new HashMap<>();

    static Map<String, Double> getCategory(int purchaseID) {
        return switch (purchaseID) {
            case 1 -> food;
            case 2 -> clothes;
            case 3 -> entertainment;
            case 4 -> other;
            default -> null;
        };
    }

    static void addPurchase(int purchaseID){

        // Asking about description of new purchase
        System.out.println("\nEnter purchase name: ");
        String name = scanner.nextLine();

        System.out.println("Enter its price: ");
        double price = Double.parseDouble(scanner.nextLine());


        // Checking if you have enough money to add new purchase
        if (Balance.accountBalance - price < 0){
            System.out.println("""
                    You don't have enough money!
                    You need to add some income.
                    """);
            return;
        }

        Objects.requireNonNull(getCategory(purchaseID)).put(name, price);

        Balance.accountBalance -= price;
    }
}
