package objects;

import java.awt.Color;
import java.awt.Graphics;

public class GameObject {
	int size;

	private int currentX;
	private int currentY;
	Color color;

	public GameObject(int representationSize, int spawningLocationX, int spawningLokationY,
			Color color) {
		this.size = representationSize;
		this.setCurrentX(spawningLocationX);
		this.setCurrentY(spawningLokationY);
		this.color = color;

	}

	public void move(int nextX, int nextY) {
		this.setCurrentX(nextX);
		this.setCurrentY(nextY);
	}

	public void draw(Graphics g) {
		g.setColor(color);
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
}
