package gui;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingUtilities;

import objects.animals.SimpleAnimal;

public class SimpleMovmentController implements Runnable {

	private SimpleAnimal gameObject;

	private SimpleGUI gui;

	ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

	public SimpleMovmentController(SimpleGUI simpleGUI, SimpleAnimal gameObject) {
		this.gui = simpleGUI;
		this.gameObject = gameObject;
		executor.scheduleAtFixedRate(() -> {
			updateObjects();
			repaint();
		}, 0, 160, TimeUnit.MILLISECONDS);
	}

	@Override
	public void run() {
	}

	private void updateObjects() {
		int nextX = 444;
		int nextY = 444;
		if (this.gameObject.getCurrentX() != nextX) {
			this.gameObject.move(this.gameObject.getCurrentX() + 1, this.gameObject.getCurrentY());
			this.gameObject.setCurrentX(this.gameObject.getCurrentX() + 1);
		}

		if (this.gameObject.getCurrentY() != nextY) {
			this.gameObject.move(this.gameObject.getCurrentX(), this.gameObject.getCurrentY() + 1);
			this.gameObject.setCurrentY(this.gameObject.getCurrentY() + 1);

		}

	}

	private void repaint() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				gui.repaintMovingPanel();
			}
		});
	}
}