import java.util.Random;

/**
 * TetrisShapeFactory constructs all the 7 shapes present in Tetris
 * Each shape is represented by its own 2D array (shapeMatrix) using 1s and 0s
 *
 * TetrisShapeFactory contains a method that randomly picks out a shape
 * from the shapes array (which holds one of each shape) and returns it.
 *
 * Thus, this class enables the creation as well as the randomization of
 * the pieces in the game.
 *
 * @author Sabirah Shuaybi
 */
public class TetrisShapeFactory {

    //A collection of all the different TetrisShapes
    private static TetrisShape[] shapes = {createI(), createO(), createT(),
            createL(), createJ(), createS(), createZ()};

    /**
     * Each of the 7 methods below is responsible for defining
     * one of the 7 TetrisShapes. ShapeMatrix arrays are represented
     * by integers where 1 is filled and 0 is empty.
     *
     * Note: These TetrisShapes are formed not by absolute locations but by
     * a 2D array of integers to define their specific shape; these definitions
     * have to be translated into concrete values to be rendered on the board.
     * (This translation/computation is done by the computeFilledCells method
     * in the TetrisUtil class)
     *
     * @return The TetrisShape created
     */
    private static TetrisShape createI() {
        int[][] shapeMatrix = new int[4][4];
        shapeMatrix[0][0] = 1;
        shapeMatrix[0][1] = 1;
        shapeMatrix[0][2] = 1;
        shapeMatrix[0][3] = 1;
        return new TetrisShape(shapeMatrix);
    }
    private static TetrisShape createO() {
        int[][] shapeMatrix = new int [2][2];
        shapeMatrix[0][0] = 1;
        shapeMatrix[0][1] = 1;
        shapeMatrix[1][0] = 1;
        shapeMatrix[1][1] = 1;
        return new TetrisShape(shapeMatrix);
    }

    private static TetrisShape createT() {
        int[][] shapeMatrix = new int [3][3];
        shapeMatrix[0][1] = 1;
        shapeMatrix[1][0] = 1;
        shapeMatrix[1][1] = 1;
        shapeMatrix[1][2] = 1;
        return new TetrisShape(shapeMatrix);
    }

    private static TetrisShape createL() {
        int[][] shapeMatrix = new int [3][3];
        shapeMatrix[0][0] = 1;
        shapeMatrix[1][0] = 1;
        shapeMatrix[2][0] = 1;
        shapeMatrix[2][1] = 1;
        return new TetrisShape(shapeMatrix);
    }
    private static TetrisShape createJ() {
        int[][] shapeMatrix = new int [3][3];
        shapeMatrix[0][1] = 1;
        shapeMatrix[1][1] = 1;
        shapeMatrix[2][0] = 1;
        shapeMatrix[2][1] = 1;
        return new TetrisShape(shapeMatrix);
    }

    private static TetrisShape createZ() {
        int[][] shapeMatrix = new int [3][3];
        shapeMatrix[0][0] = 1;
        shapeMatrix[0][1] = 1;
        shapeMatrix[1][1] = 1;
        shapeMatrix[1][2] = 1;
        return new TetrisShape(shapeMatrix);
    }

    private static TetrisShape createS() {
        int[][] shapeMatrix = new int [3][3];
        shapeMatrix[0][1] = 1;
        shapeMatrix[0][2] = 1;
        shapeMatrix[1][0] = 1;
        shapeMatrix[1][1] = 1;
        return new TetrisShape(shapeMatrix);
    }
    /**
     * Randomly picks out and returns one of the 7
     * TetrisShapes
     *
     * @return a randomly selected TetrisShape
     */
    public static TetrisShape getRandom() {
        //Generate a random integer r between 0 and 6
        Random r = new Random();
        int randomIndex = r.nextInt(7);

        return shapes[randomIndex];
    }
}
