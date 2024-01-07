import java.util.Arrays;
import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        String[][] matrix = new String[size][size];
        fillMatrix(scan, matrix);

        int currentRow = -1;
        int currentCol = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("M")) {
                    currentRow = row;
                    currentCol = col;
                    break;
                }
            }
        }

        String command = scan.nextLine();
        int eatenCheeses = 0;
        while (!command.equals("end")) {
            matrix[currentRow][currentCol] = "-";
            switch (command) {
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
                case "left":
                    currentCol--;
                    break;
                case "right":
                    currentCol++;
                    break;
            }
            if (isOutOfTerritory(currentRow, currentCol, size)) {
                System.out.println("Where is the mouse?");
                break;
            }

            if (matrix[currentRow][currentCol].equals("c")) {
                eatenCheeses++;
            } else if (matrix[currentRow][currentCol].equals("B")) {
                continue;
            }
            matrix[currentRow][currentCol] = "M";
            command = scan.nextLine();
        }
        if (eatenCheeses >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!", eatenCheeses);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.", 5 - eatenCheeses);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        System.out.println();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isOutOfTerritory(int currentRow, int currentCol, int size) {
        return currentRow < 0 || currentRow >= size
                || currentCol < 0 || currentCol >= size;
    }

    private static void fillMatrix(Scanner scan, String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scan.nextLine().split("");
        }
    }
}
