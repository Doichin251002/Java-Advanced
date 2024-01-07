import java.util.Scanner;

public class NavyBattle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        String [][] matrix = new String[size][size];
        fillMatrix(scan, matrix);

        int currentRow = -1;
        int currentCol = -1;

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (matrix[r][c].equals("S")) {
                    currentRow = r;
                    currentCol = c;
                    break;
                }
            }
        }

        String command = scan.nextLine();
        int countHits = 0;
        int countCruiser = 0;
        while (true) {
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
            String submarinePosition = matrix[currentRow][currentCol];
            if (submarinePosition.equals("-")) {
                submarinePosition = "S";
            } else if (submarinePosition.equals("*")) {
                matrix[currentRow][currentCol] = "S";
                countHits++;

                if (countHits == 3) {
                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", currentRow, currentCol);
                    break;
                }
            } else if (submarinePosition.equals("C")) {
                matrix[currentRow][currentCol] = "S";
                countCruiser++;

                if (countCruiser == 3) {
                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                    break;
                }
            }
            command = scan.nextLine();
        }

        printMatrix(matrix);
    }
    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
    private static void fillMatrix(Scanner scan, String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scan.nextLine().split("");
        }
    }
}
