package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collection;

import javax.swing.JFrame;

import objects.objectsutility.GameObjectLoader;

public class SimpleGUI {
	private static final int DRAWING_WIDTH = 600;

	private Collection<Object> movingGameObjects;
	private Collection<Object> nonMovingGameObjects;

	private JFrame frame;

	private SimpleGameObjectDrawingPanel drawingPanel;

	private SimpleMovementController movementController;

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

		movingGameObjects = GameObjectLoader.getMovingGameObjects();
		nonMovingGameObjects = GameObjectLoader.getNonMovingGameObjects();

		drawingPanel = new SimpleGameObjectDrawingPanel(movingGameObjects, nonMovingGameObjects,
				DRAWING_WIDTH);
		frame.add(drawingPanel);

		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);

		movementController = new SimpleMovementController(this, movingGameObjects,
				nonMovingGameObjects);
		new Thread(movementController).start();
	}

	private void exitProcedure() {
		frame.dispose();
		System.exit(0);
	}

	public void repaintDrawingPanel() {

		drawingPanel.repaint();
	}
}
