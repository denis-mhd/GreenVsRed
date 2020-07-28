package exception;

// Class for validating inputs
public class InputException extends Exception {

    public InputException() {
    }

    // Validate parsing numbers from string
    public void parseValidator(String[] input) {
        for (String s : input) {
            try {
                Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Only numbers");
            }
        }
    }

    // Validates numbers range given in task
    public void validateNumbersFromFirstLine(int[] input) {
        int current = input[0];
        for (int i : input) {
            if (i < 1 || i > 1000) {
                System.out.println("Invalid input! Supports only equal numbers in range 1-1000");
                throw new IllegalArgumentException();
            }
            if (current > i){
                System.out.println("Invalid input! Initial number can not be higher the second");
                throw new IllegalArgumentException();
            }
            current = i;
        }
    }

    // Validate numbers which creates the matrix
    public void validateNumbersForFillingMatrix(int[] input) {
        for (int i : input) {
            if (i != 0 && i != 1) {
                System.out.println("Invalid input! Supports only equal numbers in range 1-1000");
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateNumbersLastInputLine(int x, int y, int rounds, int row, int col) {
        if (x < 0 || x > row || y < 0 || y > col || rounds < 0) {
            System.out.println("Wrong input! Must be positive numbers and less than size of grid.");
            throw new IllegalArgumentException();
        }
    }
}
