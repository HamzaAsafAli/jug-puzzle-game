package hamza.ali.jugpuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * This class determines what the physical GUI buttons do when they are clicked.
 * Whatever button the user clicks, information about it is communicated with
 * the model Jug Puzzle View, hence it is directly affecting Jug Puzzle View and
 * the state of the game.
 * 
 *
 */
public class JugPuzzleActionListener implements ActionListener {

	private JugPuzzle jugPuzzle; // playing the game
	private JButton enter; // initially null
	private JButton options; // initially null
	private int numPresses = 0;
	private int from = 0;
	private int to = 0;

	/**
	 * Sets up the jug puzzle object
	 * 
	 * @param jugPuzzle
	 *            taken directly from the initialization in the controller.
	 */
	JugPuzzleActionListener(JugPuzzle jugPuzzle) {
		this.jugPuzzle = jugPuzzle;
	}

	/**
	 * The main method of action listener. It looks at the current button being
	 * clicked. The first button clicked is remembered, which is determined by
	 * the number of button presses which occurred. Taking from and to values
	 * and directly applying on the jug puzzle.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		// check text of current button being clicked
		// remember the first button pressed.
		// grab from and to respectively and call move on jug puzzle
		if (e.getActionCommand() == "0" || e.getActionCommand() == "1" || e.getActionCommand() == "2") {
			enter = (JButton) e.getSource();
			if (numPresses == 0) {
				from = Integer.parseInt(enter.getText());
				numPresses = numPresses + 1;
			} else {
				to = Integer.parseInt(enter.getText());
				jugPuzzle.move(from, to);
				numPresses = numPresses - 1; // reset
			}

		}
		options = (JButton) e.getSource();
		if (options.getText() == "Quit Game") {
			System.exit(0);
		} else if (options.getText() == "New Game") {
			jugPuzzle.reset();
		} else {
			// make options limited to new game and quit game button presses
			// comparisons.
		}

	}

}
