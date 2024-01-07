import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputLine = scan.nextLine();

        Map<String, Map<String, Integer>> usersActions = new TreeMap<>();

        while (!inputLine.equals("end")) {
            String [] tokens = inputLine.split("\\s+");
            String ip = tokens[0].split("=")[1];
            String username = tokens[2].split("=")[1];

            usersActions.putIfAbsent(username, new LinkedHashMap<>());

            usersActions.get(username).putIfAbsent(ip, 0);

            int countActions = usersActions.get(username).get(ip);
            usersActions.get(username).put(ip, countActions + 1);

            inputLine = scan.nextLine();
        }

        for (String username : usersActions.keySet()) {
            System.out.println(username + ": ");

            Map<String, Integer> currentIPs = usersActions.get(username);
            int countIPs = currentIPs.size();
            for (String ip : currentIPs.keySet()) {
                if (countIPs > 1) {
                    System.out.printf("%s => %d, ", ip, currentIPs.get(ip));
                } else {
                    System.out.printf("%s => %d.%n", ip, currentIPs.get(ip));
                }
                countIPs--;
            }
        }
    }
}
