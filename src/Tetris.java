/**
 * Tetris is the main application class where execution of the program begins.
 * It contains the main method and instantiates a TetrisController, a TetrisModel and
 * a TetrisTextView object.
 *
 * @author Sabirah Shuaybi
 */

public class Tetris {

    public static void main (String[] args) {
        TetrisModel model = new TetrisModel();
        TetrisTextView view = new TetrisTextView(model);
        TetrisTextController controller = new TetrisTextController(model, view);

        //Start game
        controller.start();
    }
}
