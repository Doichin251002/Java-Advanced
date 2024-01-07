import java.util.Scanner;

public class IntersectionOf2Matrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        char [][] firstMatrix = new char[rows][cols];
        enterMatrixElements(scan, rows, cols, firstMatrix);

        char [][] secondMatrix = new char[rows][cols];
        enterMatrixElements(scan, rows, cols, secondMatrix);

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    System.out.print('*');
                } else {
                    System.out.print(firstMatrix[row][col]);
                }
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    private static void enterMatrixElements(Scanner scan, int rows, int cols, char[][] firstMatrix) {
        for (int i = 0; i < rows; i++) {
            String [] data = scan.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                firstMatrix[i][j] = data[j].charAt(0);
            }
        }
    }
}
