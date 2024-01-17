import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        String [][] matrix = new String[size][size];
        fillMatrix(scan, matrix);

        int currentRow = -1;
        int currentCol = -1;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals("A")) {
                    currentRow = row;
                    currentCol = col;
                    break;
                }
            }
            if (currentRow > -1) {
                break;
            }
        }

        int totalCost = 0;
        while (totalCost < 65) {
            matrix[currentRow][currentCol] = "-";
            String direction = scan.nextLine();
            switch (direction) {
                case "up": currentRow--; break;
                case "down": currentRow++; break;
                case "left": currentCol--; break;
                case "right": currentCol++; break;
            }

            if (isOutMatrix(currentRow, currentCol, size)) {
                System.out.println("I do not need more swords!");
                System.out.printf("The king paid %d gold coins.%n", totalCost);
                printMatrix(matrix);
                return;
            }
            String currentPosition = matrix[currentRow][currentCol];
            if (Character.isDigit(currentPosition.charAt(0))) {
                totalCost += Integer.parseInt(currentPosition);
            } else if (currentPosition.equals("M")) {
                matrix[currentRow][currentCol] = "-";
                for (int row = currentRow++; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        if (matrix[row][col].equals("M")) {
                            matrix[row][col] = "-";
                            currentRow = row;
                            currentCol = col;
                            break;
                        }
                    }
                }
            }

            matrix[currentRow][currentCol] = "A";
        }

        System.out.println("Very nice swords, I will come back for more!");
        System.out.printf("The king paid %d gold coins.%n", totalCost);
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isOutMatrix(int row, int col, int size) {
        return row < 0 || row >= size
                || col < 0 || col >= size;
    }

    private static void fillMatrix(Scanner scan, String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scan.nextLine().split("");
        }
    }
}
