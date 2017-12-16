import java.awt.Color;
/**
 * TetrisShape is responsible for defining behaviors common to all TetrisShapes
 * such as clockwise and counter clock-wise rotation.
 *
 * It also holds the information about the current matrix (definition
 * of a shape, presumably the one that is 'falling')
 *
 * Note: TetrisShape is an immutable object (Intentional)
 *
 * @author Sabirah Shuaybi
 */
public class TetrisShape {

    private int[][] shapeMatrix;

    public TetrisShape(int[][] shapeMatrix) {
        this.shapeMatrix = shapeMatrix;
    }

    /**
     * Getter method for the matrix of a shape
     *
     * @return the 2D array representation of the shape
     */
    public int[][] getShapeMatrix() {
        return shapeMatrix;
    }

    /**
     * Rotates a shape clock-wise.
     *
     * @return a new TetrisShape that has been rotated clock-wise
     */
    public TetrisShape rotateCW() {
        //Delegate rotation task to TetrisUtil class, which contains
            //the utility function for rotation of a 2D matrix
        return new TetrisShape(TetrisUtil.rotate2DMatrix(this.shapeMatrix));
    }
    /**
     * Rotates a shape counter-clock-wise
     *
     * @return a new TetrisShape that has been rotated counter-clock-wise
     */
    public TetrisShape rotateCCW() {
        //Rotating an object clock-wise three times equals
            //one counter-clockwise rotation
        return rotateCW().rotateCW().rotateCW();
    }
}

