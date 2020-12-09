package objects;

import java.awt.Color;
import java.awt.Graphics;

public class GameObject {
	private int size;
	private String name;
	private int currentX;
	private int currentY;
	private Color color;

	public GameObject(int representationSize, String name, int spawningLocationX,
			int spawningLokationY, Color color) {
		this.size = representationSize;
		this.setCurrentX(spawningLocationX);
		this.setCurrentY(spawningLokationY);
		this.setColor(color);

	}

	public void move(int nextX, int nextY) {
		this.setCurrentX(nextX);
		this.setCurrentY(nextY);
	}

	public void draw(Graphics g) {
		g.setColor(getColor());
		g.fillRect(getCurrentX(), getCurrentY(), size, size);
	}

	public int getCurrentX() {
		return currentX;
	}

	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}

	public int getCurrentY() {
		return currentY;
	}

	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
