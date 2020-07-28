* Project name: Green vs. Red

* Description: 
"Green vs. Red" is a game played on 2D grid where x <= y < 1000.
Each cell on this grid can be either green (represented by 1) or red (represented by 0). The game always
receives an initinal state of the grid which we wil call "Generation Zero". After that a set of rules are 
applied across the grid and those rules form next generation.

Rules that create the next generation:
    1. Each red cell that is surrounded by exactly 3 or exactly 6 green cells will also become green in
    the next generation.
    2. A red cell will stay red in the next generation if it has eigther 0,1,2,4,5,7 or 8 green
    neighbours.
    3. Each green cell surrounded by 0,1,4,5,7,8 or green neighbours will become red in the next
    generation.
    4. A green cell will stay green in the next generation if it has either 2,3 or 6 green neighbours.
    
* Table of content: 
9 classes spread in 3 packages as describe:
package .constant - Contains one class which keeps constant Strings (prevent typos);
package .exception - InputException one class used for validating inputs; 
package .model:
    Color - enum keeps "RED" and "GREEN";
    Cell - class keeps color enum;
    CellOfInterest - class keeps coordinates of cell given in the input to follow how many times it becomes "GREEN"
    after rounds(generations);
    Grid - class keeps 2D given by input matrix (transformed in 2D matrix from Cells) and CellOfInterest;
    Game - class to proceed actions where we inject Grid to use the grid and CellOfInterest;
InputParser class used for parsing String input to numbers;
Main class reads input and use class instance to proceed the game.

* Author: Denis Mehmed
     
