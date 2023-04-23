import java.io.*;
import java.util.*;

public class Data {

    static final String outputFilePath  = "purchases.txt";

    // Saving all purchases to the file
    static void saveData() {
        // Getting purchases form lists
        File file = new File(outputFilePath);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            // Iterating through map entries
            for (int i = 1; i < 5; i++) {

                // Type of category depends on "i" variable
                Map<String, Double> categories = Purchase.getCategory(i);

                for (String key : categories.keySet()) {
                    bufferedWriter.write(i + "- " + key + "- " + categories.get(key));
                    bufferedWriter.newLine();
                }
            }

            System.out.println("\nPurchases were saved!\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Loading all purchases from the file
    static void loadData() {
        // Adding purchases to the lists
        File file = new File(outputFilePath);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String currentLine;

            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] str = currentLine.split("- ");

                // Generating list for all categories
                Map<String, Double> categories = Purchase.getCategory(Integer.parseInt(str[0]));
                categories.put(str[1], Double.parseDouble(str[2]));

            }
            System.out.println("\nPurchases were loaded!\n");

            // Updating list for all purchases
            Expenses.updateAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}