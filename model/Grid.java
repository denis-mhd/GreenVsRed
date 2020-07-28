package model;

//Class for matrix and given cell coordinates
public class Grid {

    private CellOfInterest cellOfInterest;
    private Cell[][] matrix;

    public Grid(CellOfInterest cellOfInterest, Cell[][] matrix) {
        this.cellOfInterest = cellOfInterest;
        this.matrix = matrix;
    }


    public CellOfInterest getCellOfInterest() {
        return cellOfInterest;
    }

    public void setCellOfInterest(CellOfInterest cellOfInterest) {
        this.cellOfInterest = cellOfInterest;
    }

    public Cell[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] newMatrix) {
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[0].length; j++) {
                if (newMatrix[i][j] == 0) {
                    this.matrix[i][j].setColor(Color.RED);
                } else {
                    this.matrix[i][j].setColor(Color.GREEN);
                }
            }
        }
    }
}
