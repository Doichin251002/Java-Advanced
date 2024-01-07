package BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Account> accounts;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        accounts = new HashMap<>();

        while (!input.equals("End")) {
            String [] tokens = input.split(" ");
            String command = tokens[0];

            String result = "";
            switch (command) {
                case "Create": result = createAccount(); break;
                case "Deposit": result = depositInAccount(tokens); break;
                case "SetInterest": result = setInterest(tokens); break;
                case "GetInterest": result = getInterest(tokens); break;
            }

            if (!result.isEmpty()) {
                System.out.println(result);
            }

            input = scan.nextLine();
        }
    }

    private static String getInterest(String[] tokens) {
        int id = Integer.parseInt(tokens[1]);
        int years = Integer.parseInt(tokens[2]);

        Account bankAccount = accounts.get(id);
        if (bankAccount == null) {
            return "Account does not exist";
        }
        double interest = bankAccount.getInterest(years);
        return String.format("%.2f", interest);
    }

    private static String setInterest(String[] tokens) {
        double interest = Double.parseDouble(tokens[1]);

        Account.setInterestRate(interest);
        return "";
    }

    private static String depositInAccount(String [] tokens) {
        int accountId = Integer.parseInt(tokens[1]);
        double amount = Double.parseDouble(tokens[2]);

        if (!accounts.containsKey(accountId)) {
            return "Account does not exist";
        }
        accounts.get(accountId).deposit(amount);
        return String.format("Deposited %.0f to ID%d", amount, accountId);
    }

    private static String createAccount() {
        Account bankAccount = new Account();
        int id = bankAccount.getId();
        accounts.put(id, bankAccount);

        return String.format("Account ID%d created", id);
    }
}
