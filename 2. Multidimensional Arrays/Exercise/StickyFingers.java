import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        String[] directions = scan.nextLine().split(",");

        String[][] matrix = new String[size][size];
        fillMatrix(scan, matrix);

        int positionRow = -1;
        int positionCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("D")) {
                    positionRow = row;
                    positionCol = col;
                    break;
                }
            }
        }

        int totalStolenMoney = 0;
        for (String direction : directions) {
            switch (direction) {
                case "left":
                    if (positionCol - 1 < 0) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        matrix[positionRow][positionCol] = "+";
                        positionCol--;
                    }
                    break;
                case "right":
                    if (positionCol + 1 >= size) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        matrix[positionRow][positionCol] = "+";
                        positionCol++;
                    }
                    break;
                case "up":
                    if (positionRow - 1 < 0) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        matrix[positionRow][positionCol] = "+";
                        positionRow--;
                    }
                    break;
                case "down":
                    if (positionRow + 1 >= size) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        matrix[positionRow][positionCol] = "+";
                        positionRow++;
                    }
                    break;
            }

            if (matrix[positionRow][positionCol].equals("$")) {
                int stolenMoney = positionRow * positionCol;
                totalStolenMoney += stolenMoney;
                System.out.printf("You successfully stole %d$.%n", stolenMoney);
                matrix[positionRow][positionCol] = "D";
            } else if (matrix[positionRow][positionCol].equals("P")) {
                System.out.printf("You got caught with %d$, and you are going to jail.%n", totalStolenMoney);
                matrix[positionRow][positionCol] = "#";
                printMatrix(matrix);
                return;
            } else if (matrix[positionRow][positionCol].equals("+")) {
                matrix[positionRow][positionCol] = "D";
            }

        }
        System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalStolenMoney);
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scan, String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scan.nextLine().split(" ");
        }
    }
}
