package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Collection;

import javax.swing.JPanel;

import objects.GameObject;

public class SimpleGameObjectDrawingPanel extends JPanel {

	private static final long serialVersionUID = -6291233936414618049L;

	private Collection<Object> movingGameObjects;
	private Collection<Object> nonMovingGameObjects;

	public SimpleGameObjectDrawingPanel(Collection<Object> movingGameObjects,
			Collection<Object> nonMovingGameObjects, int width) {
		this.movingGameObjects = movingGameObjects;
		this.nonMovingGameObjects = nonMovingGameObjects;

		setPreferredSize(new Dimension(width, width));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
		synchronized (nonMovingGameObjects) {

			for (Object gameObject : nonMovingGameObjects) {
				synchronized (gameObject) {
					((GameObject) gameObject).draw(g);
				}
			}
		}

		synchronized (movingGameObjects) {

			for (Object gameObject : movingGameObjects) {
				synchronized (gameObject) {
					((GameObject) gameObject).draw(g);
				}
			}
		}
	}

}