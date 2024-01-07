import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] dimension = scan.nextLine().split(" ");
        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);
        int [][] matrix = new int[rows][cols];

        fillMatrix(scan, matrix);

        int maxSum = Integer.MIN_VALUE;
        int resultRow = -1;
        int resultCol = -1;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (currentSum > maxSum) {
                    maxSum = currentSum;

                    resultRow = row;
                    resultCol = col;
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        System.out.println(matrix[resultRow][resultCol] + " " + matrix[resultRow][resultCol + 1] + " " + matrix[resultRow][resultCol + 2]);
        System.out.println(matrix[resultRow + 1][resultCol] + " " + matrix[resultRow + 1][resultCol + 1] + " " + matrix[resultRow + 1][resultCol + 2]);
        System.out.println(matrix[resultRow + 2][resultCol] + " " + matrix[resultRow + 2][resultCol + 1] + " " + matrix[resultRow + 2][resultCol + 2]);

    }

    private static void fillMatrix(Scanner scan, int [][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scan.nextInt();
            }
        }
    }
}
