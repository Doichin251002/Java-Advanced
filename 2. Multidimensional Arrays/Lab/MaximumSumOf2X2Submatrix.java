import java.util.Scanner;

public class MaximumSumOf2X2Submatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] dimensions = scan.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int [][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String [] data = scan.nextLine().split(", ");

            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(data[j]);
            }
        }
        int resultRow = -1;
        int resultCol = -1;
        int maxSum = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (currentSum > maxSum) {
                    maxSum = currentSum;

                    resultRow = row;
                    resultCol = col;
                }
            }
        }

        System.out.println(matrix[resultRow][resultCol] + " " + matrix[resultRow][resultCol + 1]);
        System.out.println(matrix[resultRow + 1][resultCol] + " " + matrix[resultRow + 1][resultCol + 1]);
        System.out.println(maxSum);
    }
}
