import exception.InputException;
import model.Cell;
import model.CellOfInterest;
import model.Game;
import model.Grid;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InputException inputException = new InputException();
        InputParser inputParser = new InputParser(inputException);

        //Read first line
        String[] input = scanner.nextLine().split(",\\s+|,");

        // Validate and parse first line of input for input type!
        int[] firstLine = inputParser.integerParser(input);

        // Validate first line of input for number range!
        inputException.validateNumbersFromFirstLine(firstLine);

        int row = firstLine[0];
        int col = firstLine[1];

        int[][] matrix = new int[row][col];
        Cell[][] cellMatrix = new Cell[row][col];
        for (int i = 0; i < row; i++) {

            //Read n-lines(rows) forming matrix
            String[] matrixInput = scanner.nextLine().split("");

            // Validate and parse n-lines of input for input type!
            int[] currentRow = inputParser.integerParser(matrixInput);
            Cell[] currentCellMatrixRow = inputParser.cellRowParser(matrixInput);

            // Validate n-lines of input for number range!
            inputException.validateNumbersForFillingMatrix(currentRow);
            matrix[i] = currentRow;
            cellMatrix[i] = currentCellMatrixRow;
        }

        //Read last line
        String[] coordinatesAndRounds = scanner.nextLine().split(",\\s+|,");

        //Validate and parse last line of input
        int[] lastLine = inputParser.integerParser(coordinatesAndRounds);
        int x = lastLine[0];
        int y = lastLine[1];
        int rounds = lastLine[2];

        //Validate last line numbers
        inputException.validateNumbersLastInputLine(x, y, rounds, row, col);

        CellOfInterest point = new CellOfInterest(x, y);
        Grid grid = new Grid(point, cellMatrix);
        Game game = new Game(grid);

        game.run(rounds, matrix);

    }
}

