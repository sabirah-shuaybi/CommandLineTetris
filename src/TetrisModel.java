import java.util.HashSet;
import java.util.Set;

/**
 * TetrisModel contains information about the current state of the game.
 * The current state of the game consists of the shape that is currently
 * falling or in action, the current location of that shape on the board
 * and the set of Cells that have landed and thus been locked onto the board.
 *
 * NOTE: Please refer to the readme.md file attached as it provides a detailed
 * explanation of what lockedCells are and how and why HashSets are used to simulate
 * a board rather than a using a separate board class.
 *
 * @author Sabirah Shuaybi
 */

public class TetrisModel {

    //Starting position of all Tetris shapes is the top center of board
    private static final int START_POS_X = 4;
    private static final int START_POS_Y = 0;

    //The collection of all cells that are locked/occupied
    private Set<Cell> lockedCells;

    //Shape currently in play/action
    private TetrisShape fallingShape;

    //Current location of the shape in action
    private Cell shapeLocation;

    public TetrisModel() {
        lockedCells =  new HashSet<>();
        createNewShape();
    }

    /**
     * Creates a new random shape
     */
    public void createNewShape() {
        fallingShape = TetrisShapeFactory.getRandom();

        //The falling shape's location will initially be set to
            //the default start position (top center)
            //this location will keep updating as shape navigates across the board
        shapeLocation = new Cell(START_POS_X, START_POS_Y);
    }

    /**
     * Getter for lockedCells (hashset)
     *
     * @return the set of locked cells (set of filled spaces on board)
     */
    public Set<Cell> getLockedCells() {
        return lockedCells;
    }

    /**
     * Setter method for updating the set of
     * locked cells (ex: when a new shape has landed)
     *
     * @param lockedCells: the set of locked cells
     */
    public void setLockedCells(Set<Cell> lockedCells) {
        this.lockedCells = lockedCells;
    }

    /**
     * Adds the cells of the falling shape into the set of
     * locked cells after collision has been detected
     *
     * @param shapeCells: the cells (ie. locations) of falling shape
     */
    public void addToLockedCells(Set<Cell> shapeCells) {
        lockedCells.addAll(shapeCells);
    }

    /**
     * Reads and returns user input (for processing)
     *
     * @return shape that is currently 'falling'
     */
    public TetrisShape getFallingShape() {
        return fallingShape;
    }

    /**
     * Reads and returns user input (for processing)
     *
     * @param fallingShape: the currently falling shape
     *                    (the shape in 'action')
     */
    public void setFallingShape(TetrisShape fallingShape) {
        this.fallingShape = fallingShape;
    }
    /**
     * Getter for the focal Cell that denotes the location of
     * the falling shape on the board.
     *
     * Note: Only need to know about one Cell because all other
     * Cells that make up the shape on the board (absolute locations)
     * can be computed relative to this main Cell
     *
     * @return current whereabouts of falling shape
     */
    public Cell getShapeLocation() {
        return shapeLocation;
    }

    /**
     * Setter for the location of the falling shape on board.
     * Useful for updating the shapes's location as
     * user navigates it across the board
     *
     * @param shapeLocation:
     */
    public void setShapeLocation(Cell shapeLocation) {
        this.shapeLocation = shapeLocation;
    }

    /** Rotates the currently falling shape clockwise */
    public void rotateCW() {
        fallingShape = fallingShape.rotateCW();
    }

    /** Rotates the currently falling shape counter-clockwise */
    public void rotateCCW() {
        fallingShape = fallingShape.rotateCCW();
    }
}