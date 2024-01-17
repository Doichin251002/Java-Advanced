import java.util.Scanner;

public class CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        String[][] pastryShop = fillMatrix(scanner, size);

        int currentRowIndex = -1;
        int currentColIndex = -1;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (pastryShop[row][col].equals("S")) {
                    currentRowIndex = row;
                    currentColIndex = col;
                    break;
                }
            }

            if (currentRowIndex > -1 && currentColIndex > -1) {
                break;
            }
        }

        int totalMoney = 0;
        while (totalMoney < 50) {
            String command = scanner.nextLine();

            pastryShop[currentRowIndex][currentColIndex] = "-";

            switch (command) {
                case "up":
                    currentRowIndex--;
                    break;
                case "down":
                    currentRowIndex++;
                    break;
                case "left":
                    currentColIndex--;
                    break;
                case "right":
                    currentColIndex++;
                    break;
            }

            if (!isValidIndex(currentRowIndex, size) || !isValidIndex(currentColIndex, size)) {
                System.out.printf("Bad news! You are out of the pastry shop.%n");
                break;
            }

            if (Character.isDigit(pastryShop[currentRowIndex][currentColIndex].charAt(0))) {
                int clientMoney = Integer.parseInt(pastryShop[currentRowIndex][currentColIndex]);

                totalMoney += clientMoney;
            } else if (pastryShop[currentRowIndex][currentColIndex].equals("P")) {
                pastryShop[currentRowIndex][currentColIndex] = "-";

                for (int row = 0; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        if (pastryShop[row][col].equals("P")) {
                            currentRowIndex = row;
                            currentColIndex = col;
                        }
                    }
                }
            }

            pastryShop[currentRowIndex][currentColIndex] = "S";
        }

        if (totalMoney >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.printf("Money: %d%n", totalMoney);
        printMatrix(pastryShop);
    }

    private static String[][] fillMatrix(Scanner scanner, int size) {
        String[][] matrix = new String[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = scanner.nextLine().split("");
        }

        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean isValidIndex(int index, int size) {
        return index >= 0 && index < size;
    }
}
