import java.util.*;

public class CitiesByContinentCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());

        Map<String, Map<String, List<String>>> continentsMap = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {
            String [] tokens = scan.nextLine().split(" ");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            continentsMap.putIfAbsent(continent, new LinkedHashMap<>());
            continentsMap.get(continent).putIfAbsent(country, new ArrayList<>());
            continentsMap.get(continent).get(country).add(city);
        }

        for (String continent : continentsMap.keySet()) {
            System.out.println(continent + ":");

            for (String country : continentsMap.get(continent).keySet()) {
                System.out.printf("  %s -> ", country);
                List<String> cities = continentsMap.get(continent).get(country);
                System.out.println(String.join(", ", cities));
            }
        }
    }
}
