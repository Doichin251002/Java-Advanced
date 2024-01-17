import java.util.Scanner;

public class BlindManBuff {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] dimensions = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        String[][] playground = new String[rows][cols];
        fillMatrix(scan, playground);

        int currentRow = -1;
        int currentCol = -1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (playground[row][col].equals("B")) {
                    currentRow = row;
                    currentCol = col;
                    break;
                }
            }
            if (currentRow > -1) {
                break;
            }
        }

        int countSteps = 0;
        int countOpponents = 0;
        String command = scan.nextLine();
        while (!command.equals("Finish")) {
            playground[currentRow][currentCol] = "-";

            switch (command) {
                case "up":
                    currentRow--;
                    if (isOutFromMatrix(currentRow, rows) || isThereObstacle(currentRow, currentCol, playground)) {
                        currentRow++;
                        playground[currentRow][currentCol] = "B";
                    }
                    break;
                case "down":
                    currentRow++;
                    if (isOutFromMatrix(currentRow, rows) || isThereObstacle(currentRow, currentCol, playground)) {
                        currentRow--;
                        playground[currentRow][currentCol] = "B";
                    }
                    break;
                case "left":
                    currentCol--;
                    if (isOutFromMatrix(currentCol, cols) || isThereObstacle(currentRow, currentCol, playground)) {
                        currentCol++;
                        playground[currentRow][currentCol] = "B";
                    }
                    break;
                case "right":
                    currentCol++;
                    if (isOutFromMatrix(currentCol, cols) || isThereObstacle(currentRow, currentCol, playground)) {
                        currentCol--;
                        playground[currentRow][currentCol] = "B";
                    }
                    break;
            }

            if (playground[currentRow][currentCol].equals("P")) {
                countOpponents++;
                countSteps++;
            } else if (playground[currentRow][currentCol].equals("-")) {
                countSteps++;
            }
            if (countOpponents >= 3) {
                break;
            }

            playground[currentRow][currentCol] = "-";
            command = scan.nextLine();
        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", countOpponents, countSteps);
    }

    private static boolean isThereObstacle(int currentRow, int currentCol, String [][] playground) {
        return playground[currentRow][currentCol].equals("O");
    }

    private static boolean isOutFromMatrix(int index, int sizeMatrix) {
        return index < 0 || index >= sizeMatrix;
    }

    private static void fillMatrix(Scanner scan, String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scan.nextLine().split("\\s+");
        }
    }
}
