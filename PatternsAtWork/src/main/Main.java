package main;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import gui.SimpleGUI;
import objects.objectsutility.GameObjectLoader;

public class Main {

	public static void main(String[] args) {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception useDefault) {
				}
				new SimpleGUI();
				GameObjectLoader.getMovingGameObjects();
			}
		};
		SwingUtilities.invokeLater(r);
	}

}
