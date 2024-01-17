import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        String [][] territory = new String[size][size];
        fillMatrix(scan, territory);

        int snakeRow = -1;
        int snakeCol = -1;
        for (int row = 0; row < territory.length; row++) {
            for (int col = 0; col < territory.length; col++) {
                if (territory[row][col].equals("S")) {
                    snakeRow = row;
                    snakeCol = col;
                    break;
                }
            }
            if (snakeRow >= 0) {
                break;
            }
        }

        int food = 0;
        while (food < 10) {
            String direction = scan.nextLine();
            territory[snakeRow][snakeCol] = ".";

            switch (direction) {
                case "left": snakeCol--; break;
                case "right": snakeCol++; break;
                case "up": snakeRow--; break;
                case "down": snakeRow++; break;
            }

            if (outOfTerritory(snakeRow, snakeCol, territory.length)) {
                System.out.println("Game over!");
                break;
            }
            if (territory[snakeRow][snakeCol].equals("B")) {
                territory[snakeRow][snakeCol] = ".";
                for (int row = snakeRow; row < territory.length; row++) {
                    for (int col = 0; col < territory.length; col++) {
                        if (territory[row][col].equals("B")) {
                            snakeRow = row;
                            snakeCol = col;
                            break;
                        }
                    }
                }
            } else if (territory[snakeRow][snakeCol].equals("*")) {
                food++;
            }
            territory[snakeRow][snakeCol] = "S";
        }

        if (food == 10) {
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + food);
        printMatrix(territory);
    }

    private static void printMatrix(String[][] territory) {
        for (int row = 0; row < territory.length; row++) {
            for (int col = 0; col < territory.length; col++) {
                System.out.print(territory[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean outOfTerritory(int snakeRow, int snakeCol, int size) {
        return snakeRow < 0 || snakeRow >= size ||
        snakeCol < 0 || snakeCol >= size;
    }

    private static void fillMatrix(Scanner scan, String[][] territory) {
        for (int row = 0; row < territory.length; row++) {
            territory[row] = scan.nextLine().split("");
        }
    }
}
