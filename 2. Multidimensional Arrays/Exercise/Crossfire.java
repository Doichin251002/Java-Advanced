import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] dimension = scan.nextLine().split(" ");
        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);

        List<List<Integer>> matrixLikeList = new ArrayList<>();
        fillMatrix(matrixLikeList, rows, cols);

        String command = scan.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            int currentRow = Integer.parseInt(command.split(" ")[0]);
            int currentCol = Integer.parseInt(command.split(" ")[1]);
            int currentSteps = Integer.parseInt(command.split(" ")[2]);

            for (int row = currentRow - currentSteps; row <= currentRow + currentSteps; row++) { //destroy in direction up-down
                if (isInMatrix(matrixLikeList, row, currentCol)) {
                    matrixLikeList.get(row).remove(currentCol);
                }
            }

            for (int col = currentCol - currentSteps; col <= currentCol + currentSteps; col++) { //destroy in direction left-right
                if (isInMatrix(matrixLikeList, currentRow, col))
                    matrixLikeList.get(currentRow).remove(col);
            }

            matrixLikeList.removeIf(List::isEmpty);

            command = scan.nextLine();
        }

        printMatrix(matrixLikeList);
    }

    private static boolean isInMatrix(List<List<Integer>> matrix, int row, int col) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int data = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(data);
                data++;
            }
        }
    }
}
