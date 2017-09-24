package hamza.ali.jugpuzzle;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * This is the GUI controller. It is responsible for the connections between
 * major clases. The controller hooks up the (observable) model to the
 * (observer) view. The particular instance of jug puzzle is the main one used
 * throughout the program.
 * 
 *
 */
public class JugPuzzleGUIController {
	private static Jug[] jugs;

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	/**
	 * Set up the GUI component of the program and hook up all the major
	 * classes. There is a main frame on which additional panels from Jug Puzzle
	 * View (main view) and Jug Puzzle Options View (optional view) are added on
	 * to the frame. Also determines where exactly on the frame the panels will
	 * be placed, what happends when you press the close button and whether or
	 * not the frame is resizable.
	 */

	public static void createAndShowGUI() {

		// Create and hook up the Model, View and the controller

		// The main Jug Puzzle View, has all the main features of the program
		JugPuzzleView view1 = new JugPuzzleView();

		// This is an addional options jug puzzle view, it is providing extra
		// features such as New Game and Quit Game buttons
		// another view class is being used for addional features so that
		// flexibility for the layout managers will be provided
		// for example: jug puzzle view uses Grid Bag Layout while Jug Puzzle
		// Options View uses Grid Layout hence the need for
		// a different class.

		JugPuzzleOptionsView view2 = new JugPuzzleOptionsView();

		// Model
		JugPuzzle jugPuzzle = new JugPuzzle();
		jugPuzzle.addObserver(view1); // hook up the model to the view, the view
										// will observe changes in the model

		// make the frame
		JFrame frame = new JFrame("Jug Puzzle");
		// set frame size
		frame.setSize(250, 190);
		// not allowing resizing
		frame.setResizable(false);
		// exit on pressing close
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// north side panel, for the main components, this is from JugPuzzleView
		frame.getContentPane().add(view1, BorderLayout.NORTH);

		// south side panel, for extra features, add view 2 which is
		// JugPuzzleOptionsView.
		frame.getContentPane().add(view2, BorderLayout.SOUTH);

		// the controller is only able to assign those components which were
		// made locally inside here, the main panel which is located inside of
		// JugPuzzleView has to
		// assign its buttons to the Jug Puzzle Action Listener Class
		// we send the jug puzzle instance into the action listener and then we
		// send that action listener to view and hook up buttons inside the
		// view.
		JugPuzzleActionListener al1 = new JugPuzzleActionListener(jugPuzzle);
		view1.hookupactionlistener(al1); // send action listener to the main jug
											// puzzle view
		view2.hookupactionlistener(al1); // send action listener to the options
											// jug puzzle view

		// final frame properties
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		jugPuzzle.notifyObservers(); // let model jugPuzzle tell JugPuzzleView
										// to update.

	}

}
