import java.util.Scanner;

public class Selling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        String [][] bakery = new String[size][size];
        fillMatrix(scan, bakery);

        int currentRow = -1;
        int currentCol = -1;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (bakery[row][col].equals("S")) {
                    currentRow = row;
                    currentCol = col;
                    break;
                }
            }
            if (currentRow > -1) {
                break;
            }
        }

        int money = 0;
        while (money < 50) {
            String command = scan.nextLine();
            bakery[currentRow][currentCol] = "-";

            switch (command) {
                case "up": currentRow--; break;
                case "down": currentRow++; break;
                case "left": currentCol--; break;
                case "right": currentCol++; break;
            }

            if (isOutOfBakery(currentRow, currentCol, size)) {
                System.out.println("Bad news, you are out of the bakery.");
                break;
            }

            if (Character.isDigit(bakery[currentRow][currentCol].charAt(0))) {
                money += Integer.parseInt(bakery[currentRow][currentCol]);
            } else if (bakery[currentRow][currentCol].equals("O")) {
                bakery[currentRow][currentCol] = "-";
                for (int row = currentRow; row < bakery.length; row++) {
                    for (int col = 0; col < bakery.length; col++) {
                        if (bakery[row][col].equals("O")) {
                            currentRow = row;
                            currentCol = col;
                            break;
                        }
                    }
                }
            }

            bakery[currentRow][currentCol] = "S";
        }

        if (money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: " + money);
        printMatrix(bakery);

    }

    private static void printMatrix(String[][] bakery) {
        for (int row = 0; row < bakery.length; row++) {
            for (int col = 0; col < bakery.length; col++) {
                System.out.print(bakery[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isOutOfBakery(int currentRow, int currentCol, int size) {
        return currentRow < 0 || currentRow >= size ||
                currentCol < 0 || currentCol >= size;
    }

    private static void fillMatrix(Scanner scan, String[][] bakery) {
        for (int row = 0; row < bakery.length; row++) {
            bakery[row] = scan.nextLine().split("");
        }
    }

}
