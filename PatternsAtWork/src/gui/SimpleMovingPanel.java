package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import objects.animals.SimpleAnimal;

public class SimpleMovingPanel extends JPanel {

	private static final long serialVersionUID = -6291233936414618049L;

	private SimpleAnimal gameObject;

	public SimpleMovingPanel(SimpleAnimal gameObject, int width) {
		this.gameObject = gameObject;
		setPreferredSize(new Dimension(width, width));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());

		gameObject.draw(g);

	}

}