import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[rows][];
        fillMatrix(scan, matrix);

        int numberRow = scan.nextInt();
        int numberCol = scan.nextInt();
        int wrongNumber = matrix[numberRow][numberCol];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongNumber) {
                    correctNumber(matrix, row, col);
                } else {
                    System.out.print(matrix[row][col] + " ");
                }
            }
            System.out.println();
        }
    }

    private static void correctNumber(int[][] matrix, int row, int col) {
        int sum = 0;

        int upperNumberRow = row - 1;
        if (upperNumberRow >= 0 && upperNumberRow < matrix.length) {
            if (matrix[upperNumberRow][col] != matrix[row][col]) {
                sum += matrix[upperNumberRow][col];
            }
        }

        int rightNumberCol = col + 1;
        if (rightNumberCol >= 0 && rightNumberCol < matrix[row].length) {
            if (matrix[row][rightNumberCol] != matrix[row][col]) {
                sum += matrix[row][rightNumberCol];
            }
        }

        int lowerNumberRow = row + 1;
        if (lowerNumberRow >= 0 && lowerNumberRow < matrix.length) {
            if (matrix[lowerNumberRow][col] != matrix[row][col]) {
                sum += matrix[lowerNumberRow][col];
            }
        }

        int leftNumberCol = col - 1;
        if (leftNumberCol >= 0 && leftNumberCol < matrix[row].length) {
            if (matrix[row][leftNumberCol] != matrix[row][col]) {
                sum += matrix[row][leftNumberCol];
            }
        }

        System.out.print(sum + " ");
    }

    private static void fillMatrix(Scanner scan, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String[] data = scan.nextLine().split(" ");

            int[] currentRow = Arrays.stream(data)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = currentRow;
        }
    }
}
