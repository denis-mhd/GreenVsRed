import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",\\s+|,");

        int row = 0;
        int col = 0;

        // Validating first line of input!
        try {
            row = Integer.parseInt(input[0]);
            col = Integer.parseInt(input[1]);
            if (col < 1 || col > 1000 || row != col){
                throw new IOException("Wrong input! Numbers should be in range 1-1000.");
            }
        }catch (IOException e){
            System.out.println("Wrong input! Only numbers.");
        }

        // Validating next (n = cellRow) lines of input and filling the matrix
        Cell[][] matrix = new Cell[row][col];
        int[][] nextMatrix = new int[row][col];
        try {
            for (int i = 0; i < col; i++) {
                String[] matrixInput = scanner.nextLine().split("");
                for (int j = 0; j < matrixInput.length; j++) {
                    if (matrixInput[j].equals("0")) {
                        nextMatrix[i][j] = 0;
                        Cell red = new Cell(Color.RED);
                        matrix[i][j] = red;
                    } else if (matrixInput[j].equals("1")) {
                        nextMatrix[i][j] = 1;
                        Cell green = new Cell(Color.GREEN);
                        matrix[i][j] = green;
                    } else {
                        throw new IOException("Wrong input! Supports only 0 and 1.");
                    }
                }
            }
        }catch (IOException e){
            System.out.println("Wrong input! Supports only 0 and 1.");
        }


        //Validating last input line
        String[] coordinatesAndRounds = scanner.nextLine().split(",\\s+|,");
        int rounds = 0;
        int x = 0;
        int y = 0;

        try{
            x = Integer.parseInt(coordinatesAndRounds[0]);
            y = Integer.parseInt(coordinatesAndRounds[1]);
            rounds = Integer.parseInt(coordinatesAndRounds[2]);

            if(x<0 || x>row || y<0 || y>col || rounds<0){
                throw new IllegalArgumentException("Wrong input! Must be positive numbers and less than size of grid.");
            }

        }catch (IllegalArgumentException e){
            System.out.println("Wrong input! Must be positive numbers");
        }

        CellOfInterest point = new CellOfInterest(x,y);

        Grid grid = new Grid(point, matrix);

        Game game = new Game(grid);

        game.run(rounds, nextMatrix);



    }
}
