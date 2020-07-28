package model;

import static constant.Constant.GREEN;
import static constant.Constant.RED;

// Class Game follows task actions
public class Game {
    private Grid grid;

    public Game(Grid grid) {
        this.grid = grid;
    }

    public void run(int rounds, int[][] nextMatrix) {
        System.out.println(this.round(rounds, nextMatrix));
    }

    // Start game for each round
    private int round(int rounds, int[][] nextMatrix) {

        int resultCounter = 0;
        int col = this.grid.getCellOfInterest().getX();
        int row = this.grid.getCellOfInterest().getY();

        // Looping rounds including "Generation Zero"
        for (int i = 0; i <= rounds; i++) {

            for (int j = 0; j < this.grid.getMatrix().length; j++) {
                for (int k = 0; k < this.grid.getMatrix()[0].length; k++) {

                    int greenCounter = 0;

                    greenCounter = checkPositionsAroundCells(j, k, greenCounter);

                    // Covers rule 1 and 2
                    if (this.grid.getMatrix()[j][k].getColor().name().equals(RED)) {
                        if (greenCounter == 3 || greenCounter == 6) {
                            nextMatrix[j][k] = 1;
                        }

                        // Covers rule 3 and 4
                    } else if (this.grid.getMatrix()[j][k].getColor().name().equals(GREEN)) {
                        if (greenCounter != 2 && greenCounter != 3 && greenCounter != 6) {
                            nextMatrix[j][k] = 0;
                        }
                    }

                    // Count how many times given cell will become green
                    if (j == row && k == col) {
                        if (this.grid.getMatrix()[j][k].getColor().name().equals(GREEN)) {
                            resultCounter++;
                        }
                    }
                }

            }
            // Set new formed matrix after changes
            this.grid.setMatrix(nextMatrix);
        }
        return resultCounter;
    }

    //Check positions around each cell and receive count of green cells
    private int checkPositionsAroundCells(int j, int k, int greenCounter) {
        if (validatePosition(j - 1, k, this.grid.getMatrix())) {
            if (this.grid.getMatrix()[j - 1][k].getColor().name().equals(GREEN)) {
                greenCounter++;
            }
        }
        if (validatePosition(j - 1, k + 1, this.grid.getMatrix())) {
            if (this.grid.getMatrix()[j - 1][k + 1].getColor().name().equals(GREEN)) {
                greenCounter++;
            }
        }
        if (validatePosition(j, k + 1, this.grid.getMatrix())) {
            if (this.grid.getMatrix()[j][k + 1].getColor().name().equals(GREEN)) {
                greenCounter++;
            }
        }
        if (validatePosition(j + 1, k + 1, this.grid.getMatrix())) {
            if (this.grid.getMatrix()[j + 1][k + 1].getColor().name().equals(GREEN)) {
                greenCounter++;
            }
        }
        if (validatePosition(j + 1, k, this.grid.getMatrix())) {
            if (this.grid.getMatrix()[j + 1][k].getColor().name().equals(GREEN)) {
                greenCounter++;
            }
        }
        if (validatePosition(j + 1, k - 1, this.grid.getMatrix())) {
            if (this.grid.getMatrix()[j + 1][k - 1].getColor().name().equals(GREEN)) {
                greenCounter++;
            }
        }
        if (validatePosition(j, k - 1, this.grid.getMatrix())) {
            if (this.grid.getMatrix()[j][k - 1].getColor().name().equals(GREEN)) {
                greenCounter++;
            }
        }
        if (validatePosition(j - 1, k - 1, this.grid.getMatrix())) {
            if (this.grid.getMatrix()[j - 1][k - 1].getColor().name().equals(GREEN)) {
                greenCounter++;
            }
        }
        return greenCounter;
    }

    // Validating every position around pointed cell to prevent Out Of Bounds exception
    private boolean validatePosition(int x, int y, Cell[][] matrix) {
        return !(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length);
    }
}
