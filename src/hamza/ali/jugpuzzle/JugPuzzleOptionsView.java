package hamza.ali.jugpuzzle;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This class is the view which presents optional and additional components. The
 * components presented here are not dynamic and don't have to be present in the
 * main Jug Puzzle view since this class does not have to observe changes in the
 * model. The components here are just responsible for altering the state of the
 * game, there is nothing which needs to be dynamically changed.
 * 
 *
 */
public class JugPuzzleOptionsView extends JPanel {
	// this view class will carry additional features which compliment the game
	// here panel 2 contains new game and quit game, this is a separate panel
	// this panel has additional features and is different from the panel being
	// used by jug Puzzle view
	// this panel has New Game and Quit Game buttons, features which are not
	// dynamic and are not constantly updating the game.
	// this class does not need to observe the model because the following
	// buttons dont have dynamic features and dont need to refer to
	// the model, they just update the state of the game.
	private JButton q1, q2;

	public JugPuzzleOptionsView() {
		// using a different layout manager than the one used in jug puzzle
		// view.
		this.setLayout(new GridLayout(0, 2, 4, 4));
		q1 = new JButton("New Game");
		q1.setBackground(Color.GREEN);
		this.add(q1);
		q2 = new JButton("Quit Game");
		q2.setBackground(Color.PINK);
		this.add(q2);
	}

	/**
	 * Responsible for connecting the buttons to the action listener. It is
	 * important to note that the action listener is supplied from within the
	 * controller, the view here is just hooking the additional buttons up.
	 * 
	 * @param jal
	 *            a action listener object supplied from controller.
	 */
	public void hookupactionlistener(JugPuzzleActionListener jal) {
		q1.addActionListener(jal);
		q2.addActionListener(jal);
	}
}
