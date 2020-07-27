
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

    public void setMatrix(int[][] nextMatrix) {
            for (int i = 0; i < nextMatrix.length; i++) {
                for (int j = 0; j < nextMatrix[0].length; j++) {
                    if (nextMatrix[i][j] == 0){
                        this.getMatrix()[i][j].setColor(Color.RED);
                    }else{
                        this.getMatrix()[i][j].setColor(Color.GREEN);
                    }
                }
            }
    }
}
