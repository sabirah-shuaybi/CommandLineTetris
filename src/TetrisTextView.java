import java.util.Set;

/**
 * TetrisView sets up the view for Tetris.
 * TetrisView handles the following:
 * 1)Setting up the 'board', header and footer of view
 * 2)Rendering the board based on the state of each
 * location on board (falling, locked or empty)
 * 3)Updating the scores on screen
 * 4)Informing the user when they have lost the game
 * 4)Displaying instructions for playing
 *
 * @author Sabirah Shuaybi
 */
public class TetrisTextView {
    private TetrisModel model;
    private int numLinesCleared = 0;
    private int numTetrisCleared = 0;

    public TetrisTextView(TetrisModel model) {
        this.model = model;
    }

    /**
     * Main render method, called by controller.
     * In charge of delegating all tasks related to
     * displaying/rendering the view
     */
    public void render() {
        this.displayHeader();
        this.renderBoard();
        this.displayFooter();
    }

    /**
     * Displays header of the view.
     * Header consists of the two scoring aspects and
     * a line of dashes signifying the top of the board
     */
    private void displayHeader() {
        System.out.println("Number of Lines Cleared: " + numLinesCleared);
        System.out.println("Number of Tetrises Cleared: " + numTetrisCleared);
        System.out.println("----------");
    }

    /**
     * Displays footer of the view.
     * A line of dashes signifying the bottom of the board and
     * the prompt informing user what to do for input
     */
    private void displayFooter() {
        System.out.println("----------");

        //Prompt the user for input
        System.out.println("Please enter a moveDown (d, p, l, r, z, x). " +
                "Type 'h' for help and 'q' to quit game.");

    }
    /**
     * This method handles drawing up the board for user.
     * Uses information in the two hash sets to render board.
     * Places an X where locked cells are and * where the cells
     * of the currently falling piece are. Inserts a '.' everywhere
     * else to signify the unoccupied spaces on board
     */
    private void renderBoard() {
        Set<Cell> lockedCells = model.getLockedCells();

        //Determine where the falling shape cells are and store these cells in a hash set
        TetrisShape fallingShape = model.getFallingShape();
        Cell shapeLocation = model.getShapeLocation();
        Set<Cell> tetrisPieceCells = TetrisUtil.computeFilledCells(fallingShape, shapeLocation);

        //Go through the entire board and for each loc, evaluate it's state
        for (int row=0; row<18; row++) {
            for (int col=0; col<10; col++) {
                Cell loc = new Cell(col, row);
                //If state = locked, display a X
                if(lockedCells.contains(loc)) {
                    System.out.print("X");
                }
                //If state = falling, display a star
                else if(tetrisPieceCells.contains(loc)) {
                    System.out.print("*");
                }
                //Else, state = empty, so display a dot
                else {
                    System.out.print(".");
                }
            }
            //New line: Proceed to the next row
            System.out.println();
        }
    }

    /** Updates the number of lines cleared by user */
    public void incrementLinesCleared() {
        numLinesCleared++;
    }

    /**
     * Updates the number of Tetrises cleared by user
     * A Tetris occurs when four lines are simultaneously cleared
     */
    public void incrementTetrisCleared() {
        numTetrisCleared++;
    }

    /** Displays a message to user informing them that they have lost. */
    public void displayGameOver() {
        System.out.println("You lost! Game over.");
    }

    /**
     * Prints out instructions defining what the inputs mean,
     * how to play the game and when the game is over
     */
    public void printInstructions() {
        System.out.println("Try to complete rows of cells at the bottom (with no gaps).\n" +
        "Each complete row will disappear, giving you more room as you continue playing.\n" +
        "Game is over if board is filled in such a way that the next piece has no room to fall\n" +
        "Enter d to moveDown shape one unit down.\n" +
        "Enter l to moveDown shape one unit left.\n" +
        "Enter r to moveDown shape one unit right.\n" +
        "Enter p to drop the shape all the way down\n" +
        "Enter z to rotate shape clockwise.\n" +
        "Enter x to rotate shape counter-clockwise.\n" +
        "Enter q to quit the game.\n");
    }


}
