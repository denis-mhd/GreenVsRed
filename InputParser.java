import exception.InputException;
import model.Cell;
import model.Color;

// Class to parse the input
public class InputParser {
    private final InputException inputException;

    public InputParser(InputException inputException) {
        this.inputException = inputException;
    }

    // Method for parsing String[] to integer[]
    public int[] integerParser(String[] input) {
        this.inputException.parseValidator(input);
        int[] parsedInput = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            parsedInput[i] = Integer.parseInt(input[i]);
        }
        return parsedInput;
    }

    // Method creates Object[] based on given task
    public Cell[] cellRowParser(String[] matrixRowInput) {
        Cell[] cellRowParser = new Cell[matrixRowInput.length];
        for (int i = 0; i < matrixRowInput.length; i++) {
            if (matrixRowInput[i].equals("0")) {
                cellRowParser[i] = new Cell(Color.RED);
            } else
                cellRowParser[i] = new Cell(Color.GREEN);
        }
        return cellRowParser;
    }
}
