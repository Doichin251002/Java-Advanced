import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Double>> shopProducts = new TreeMap<>();

        String command = scan.nextLine();
        while (!command.equals("Revision")) {
            String [] tokens = command.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            shopProducts.putIfAbsent(shop, new LinkedHashMap<>());
            shopProducts.get(shop).put(product, price);

            command = scan.nextLine();
        }

        for (String shop : shopProducts.keySet()) {
            String [] products = shopProducts.get(shop).keySet().toArray(new String[shopProducts.get(shop).size()]);
            System.out.println(shop + "->");
            for (String product : products) {
                System.out.printf("Product: %s, Price: %.1f%n", product, shopProducts.get(shop).get(product));
            }
        }
    }
}
