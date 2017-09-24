package hamza.ali.jugpuzzle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class is the main view of the program. This class contains buttons and
 * various JTextfields. This class observers changes in the model and updates
 * the GUI accordingly.
 * 
 *
 */
public class JugPuzzleView extends JPanel implements Observer {
	private JTextField jug0;
	private JTextField jug1;
	private JTextField jug2;
	private JTextField movesdisplay;
	private JButton b1, b2, b3;
	private JButton q1, q2;

	public JugPuzzleView() {
		// Method of JComponent
		this.setLayout(new GridBagLayout());
		GridBagConstraints specs = new GridBagConstraints();
		Font font1 = new Font("Arial", Font.BOLD, 13);
		jug0 = new JTextField(2); // display amount in jug 0
		jug0.setFont(font1);
		jug0.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // remove
																		// outline
																		// border
																		// to be
																		// seam-less
																		// with
																		// background.
		jug0.setOpaque(false); // don't paint the pixels
		jug0.setText("8" + "/" + "8");
		specs.gridx = 1;
		specs.gridy = 0;
		specs.insets = new Insets(10, 10, 10, 10); // minimum amount of space
													// b/w this and other
													// components,
													// top-left-bottom-right
		jug0.setEditable(false);
		this.add(jug0, specs);

		jug1 = new JTextField(2); // display amount in jug 1
		jug1.setFont(font1);
		jug1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		jug1.setOpaque(false);
		jug1.setText("0" + "/" + "5");
		specs.gridx = 2;
		specs.gridy = 0;
		jug1.setBackground(Color.WHITE);
		jug1.setEditable(false);
		this.add(jug1, specs);

		jug2 = new JTextField(2); // display amount in jug 2
		jug2.setFont(font1);
		jug2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		jug2.setOpaque(false);
		jug2.setText("0" + "/" + "3");
		specs.gridx = 3;
		specs.gridy = 0;
		jug2.setBackground(Color.WHITE);
		jug2.setEditable(false);
		this.add(jug2, specs);

		b1 = new JButton("0");
		b1.setFont(font1);
		specs.gridx = 1;
		specs.gridy = 1;
		this.add(b1, specs);
		b2 = new JButton("1");
		b2.setFont(font1);
		specs.gridx = 2;
		specs.gridy = 1;
		this.add(b2, specs);
		b3 = new JButton("2");
		b3.setFont(font1);
		specs.gridx = 3;
		specs.gridy = 1;
		this.add(b3, specs);
		movesdisplay = new JTextField("Moves: 0");
		movesdisplay.setFont(font1);
		movesdisplay.setHorizontalAlignment(JTextField.CENTER);
		movesdisplay.setEditable(false);
		specs.fill = GridBagConstraints.HORIZONTAL;
		specs.ipady = 5;
		specs.weightx = 0.0;
		specs.gridwidth = 3;
		specs.gridx = 1;
		specs.gridy = 3;
		this.add(movesdisplay, specs);

	}

	/**
	 * Responsible for connecting the buttons to the action listener. It is
	 * important to note that the action listener is supplied from within the
	 * controller, the view here is just hooking the respective buttons up.
	 * 
	 * @param jal
	 *            a action listener object supplied from controller.
	 */
	public void hookupactionlistener(JugPuzzleActionListener jal) {
		b1.addActionListener(jal);
		b2.addActionListener(jal);
		b3.addActionListener(jal);
	}

	/**
	 * This is the main component of the observer design pattern. This method
	 * observes changes in the model and updates the text fields (which are
	 * created here) on the GUI interface. It is also responsible for disabling
	 * any buttons if the user has already won the game.
	 */

	@Override
	public void update(Observable arg0, Object arg1) {
		JugPuzzle jugPuzzle = (JugPuzzle) arg0;
		if (jugPuzzle.getIsPuzzleSolved()) {
			jug0.setText(jugPuzzle.eachJug(0));
			jug1.setText(jugPuzzle.eachJug(1));
			jug2.setText(jugPuzzle.eachJug(2));
			b1.setEnabled(false); // once the game is won, disable all three
									// buttons
			b2.setEnabled(false);
			b3.setEnabled(false);
			movesdisplay.setText("You WON with " + jugPuzzle.getMoves() + " moves!!");
		} else {
			b1.setEnabled(true); // make sure that while the game is going on,
									// all three buttons remain active
			b2.setEnabled(true);
			b3.setEnabled(true);
			jug0.setText(jugPuzzle.eachJug(0));
			jug1.setText(jugPuzzle.eachJug(1));
			jug2.setText(jugPuzzle.eachJug(2));
			movesdisplay.setText("Moves: " + Integer.toString(jugPuzzle.getMoves()));
		}

	}

}