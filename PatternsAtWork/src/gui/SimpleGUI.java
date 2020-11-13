package gui;

//import javafx.scene.paint.Color;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import objects.animals.SimpleAnimal;
import objects.animals.herbivore.SimpleHare;

public class SimpleGUI {
	private static final int DRAWING_WIDTH = 600;
	private SimpleAnimal gameObject = new SimpleHare(10, 123, 123, Color.DARK_GRAY);

	private JFrame frame;

	private SimpleMovingPanel movingPanel;

	private SimpleMovmentController movementController;

	public SimpleGUI() {

		frame = new JFrame();
		frame.setTitle("SmallSim");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				exitProcedure();
			}
		});

		movingPanel = new SimpleMovingPanel(gameObject, DRAWING_WIDTH);
		frame.add(movingPanel);

		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);

		movementController = new SimpleMovmentController(this, gameObject);
		new Thread(movementController).start();
	}

	private void exitProcedure() {
		frame.dispose();
		System.exit(0);
	}

	public void repaintMovingPanel() {
		movingPanel.repaint();
	}
}
