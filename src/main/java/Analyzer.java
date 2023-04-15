import java.util.*;

public class Analyzer {

    static Scanner scanner = new Scanner(System.in);

    static void analyze(){
        while (true){

            // Showing menu
            System.out.println("""

                    How do you want to sort?
                    1) Sort all purchases
                    2) Sort by type
                    3) Sort certain type
                    4) Back""");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

            /*
            Sort All – sort the entire shopping list and display it so that
            the most expensive purchases are at the top of the list.
            */
                case 1 -> sortAll();

            /*
            Sort By Type – show which category eats the most money.
            If a category has no purchases in it the total sum should be $0.
             */
                case 2 -> sortByType();

            /*
            Sort Certain Type – same as Sort All, but for a specific category.
            */
                case 3 -> sortCertainType();

                case 4 -> {
                    System.out.println();
                    return;
                }
                default -> System.out.println("\nWrong input");
            }
        }
    }

    static void sortAll(){
        if(!Purchase.all.isEmpty()){
            System.out.println();
            Expenses.showExpenses(sortCategory(Purchase.all));
        }else {
            System.out.println("\nThe purchase list is empty!");
        }
    }

    static void sortByType(){
        System.out.println();
        Map<String, Double> map = new HashMap<>();
        map.put("Food", Expenses.countTotal(Purchase.getCategory(1)));
        map.put("Clothes", Expenses.countTotal(Purchase.getCategory(2)));
        map.put("Entertainment", Expenses.countTotal(Purchase.getCategory(3)));
        map.put("Other", Expenses.countTotal(Purchase.getCategory(4)));

        for (String key : sortCategory(map).keySet()) {
            System.out.println(key + " - $" + String.format("%.2f", map.get(key)));
        }
    }

    static void sortCertainType(){
        System.out.println("""

                Choose the type of purchase
                1) Food
                2) Clothes
                3) Entertainment
                4) Other""");

        int categoryToSort = Integer.parseInt(scanner.nextLine());
        System.out.println();

        if (Purchase.getCategory(categoryToSort).isEmpty()){
            System.out.println("The purchase list is empty!");
            return;
        }
        switch (categoryToSort) {
            case 1 -> System.out.println("Food:");
            case 2 -> System.out.println("Clothes:");
            case 3 -> System.out.println("Entertainment:");
            case 4 -> System.out.println("Other:");
            default -> System.out.println("\nWrong input");
        }

        Expenses.showExpenses(sortCategory(Purchase.getCategory(categoryToSort)));
    }

    static Map<String, Double> sortCategory(Map<String, Double> unsortedMap){

        List<Map.Entry<String, Double>> list = new ArrayList<>(unsortedMap.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        Map<String, Double> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Double> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
