import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] size = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);
        String[][] secretMap = new String[rows][cols];
        fillMatrix(scan, secretMap);

        String currentPosition;
        int currentRow = -1;
        int currentCol = -1;
        for (int row = 0; row < secretMap.length; row++) {
            for (int col = 0; col < secretMap[0].length; col++) {
                currentPosition = secretMap[row][col];
                if (currentPosition.equals("Y")) {
                    currentRow = row;
                    currentCol = col;
                    break;
                }
            }
            if (currentRow > -1) {
                break;
            }
        }

        List<String> steps = new ArrayList<>();
        String direction = scan.nextLine();
        while (!direction.equals("Finish")) {
            int previouslyRow = currentRow;
            int previouslyCol = currentCol;
            secretMap[previouslyRow][previouslyCol] = "-";

            switch (direction) {
                case "up":
                    if (isInField(--currentRow, currentCol, secretMap)) {
                        steps.add(direction);
                    } else {
                        currentRow = previouslyRow;
                    }
                    break;
                case "down":
                    if (isInField(++currentRow, currentCol, secretMap)) {
                        steps.add(direction);
                    } else {
                        currentRow = previouslyRow;
                    }
                    break;
                case "left":
                    if (isInField(currentRow, --currentCol, secretMap)) {
                        steps.add(direction);
                    } else {
                        currentCol = previouslyCol;
                    }
                    break;
                case "right":
                    if (isInField(currentRow, ++currentCol, secretMap)) {
                        steps.add(direction);
                    } else {
                        currentCol = previouslyCol;
                    }
                    break;
            }
            currentPosition = secretMap[currentRow][currentCol];
            if (currentPosition.equals("T")) {
                currentRow = previouslyRow;
                currentCol = previouslyCol;

                if (!steps.isEmpty()) {
                    steps.remove(direction);
                }
            } else if (currentPosition.equals("X")) {
                System.out.println("I've found the treasure!");

                String directionsString = steps.toString().replaceAll("[\\[\\]]", "");
                System.out.println("The right path is " + directionsString);
                return;
            }

            secretMap[currentRow][currentCol] = "Y";

            direction = scan.nextLine();
        }

        System.out.println("The map is fake!");
    }

    private static boolean isInField(int row, int col, String [][] map) {
        return row >= 0 && row < map.length
                && col >= 0 && col < map[0].length;
    }

    private static void fillMatrix(Scanner scan, String[][] map) {
        for (int row = 0; row < map.length; row++) {
            map[row] = scan.nextLine().split("\\s+");
        }
    }
}
